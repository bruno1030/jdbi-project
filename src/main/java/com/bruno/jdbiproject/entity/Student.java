package com.bruno.jdbiproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Student {

    private String name;
    private int age;
    private Stage stage;
    private Date registrationDate;

}
