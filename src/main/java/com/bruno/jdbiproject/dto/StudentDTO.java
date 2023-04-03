package com.bruno.jdbiproject.dto;

import com.bruno.jdbiproject.entity.Stage;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentDTO {

    private String name;
    private int age;
    private Stage stage;

}
