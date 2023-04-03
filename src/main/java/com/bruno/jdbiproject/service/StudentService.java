package com.bruno.jdbiproject.service;

import com.bruno.jdbiproject.dto.StudentDTO;
import com.bruno.jdbiproject.entity.Student;
import com.bruno.jdbiproject.mapper.StudentMapper;
import com.bruno.jdbiproject.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class StudentService {

    private final StudentRepository repository;
    private StudentMapper mapper;

    public StudentService(StudentRepository repository, StudentMapper mapper){
        this.repository = repository;
        this.mapper = mapper;
    }

    public void save(StudentDTO studentDTO){
        Student student = mapper.dtoToEntity(studentDTO);
        repository.insert(student);
    }

}
