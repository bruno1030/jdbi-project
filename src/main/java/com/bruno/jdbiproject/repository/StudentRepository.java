package com.bruno.jdbiproject.repository;

import com.bruno.jdbiproject.entity.Student;

import java.util.List;

public interface StudentRepository {

    List<Student> getAllStudents();

    void insert(Student student);

    void insertRegistry(Student student);

    List<Student> getStudentsInDebt();
}
