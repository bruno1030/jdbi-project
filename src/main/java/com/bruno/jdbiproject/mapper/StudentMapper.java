package com.bruno.jdbiproject.mapper;

import com.bruno.jdbiproject.dto.StudentDTO;
import com.bruno.jdbiproject.entity.Student;

import java.time.LocalDate;
import java.util.Date;

public class StudentMapper {

    public Student dtoToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setAge(studentDTO.getAge());
        student.setStage(studentDTO.getStage());
        student.setRegistrationDate(new Date());

        return student;
    }

}
