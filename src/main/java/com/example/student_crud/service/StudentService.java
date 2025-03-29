package com.example.student_crud.service;

import com.example.student_crud.model.Student;
import com.example.student_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service  // Marks this class as a service layer
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Get all students or filter by name if provided
    public List<Student> getStudents(Optional<String> name) {
        return name.map(s -> studentRepository.findAll().stream()
                .filter(student -> student.getName().equalsIgnoreCase(s))
                .collect(Collectors.toList())).orElseGet(() -> studentRepository.findAll());
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Add a new student
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    // Update an existing student
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setAge(studentDetails.getAge());
        return studentRepository.save(student);
    }

    // Delete a student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
