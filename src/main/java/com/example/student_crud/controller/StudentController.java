package com.example.student_crud.controller;
import com.example.student_crud.model.Student;
import com.example.student_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController  // Marks this as a REST API controller
@RequestMapping("/students")  // Base URL for student-related endpoints
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Get all students (or filter by name if provided)
    @GetMapping
    public List<Student> getStudents(@RequestParam Optional<String> name) {
        return studentService.getStudents(name);
    }

    // Get a single student by ID
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // Add a new student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Update student details
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
