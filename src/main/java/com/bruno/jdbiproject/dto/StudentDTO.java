package com.bruno.jdbiproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentDTO {

    private int id;
    private String name;
    private int age;
    private String stage;
    private String registry;
    private String registrationDate;

}
