package com.example.student_crud.model;

import jakarta.persistence.*;

@Entity  // Marks this class as a JPA entity (database table)
@Table(name = "students")  // Specifies the table name in the database
public class Student {

    @Id  // Marks this field as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-increment ID
    private Long id;

    private String name;
    private String email;
    private int age;

    // Constructors
    public Student() {}

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
