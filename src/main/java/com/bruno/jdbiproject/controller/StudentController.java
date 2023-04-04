package com.bruno.jdbiproject.controller;

import com.bruno.jdbiproject.dto.StudentDTO;
import com.bruno.jdbiproject.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getStudents() {
        return new ResponseEntity(service.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody StudentDTO studentDTO) {
        try {
            service.save(studentDTO);
            return new ResponseEntity("Student saved succesfully", HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
