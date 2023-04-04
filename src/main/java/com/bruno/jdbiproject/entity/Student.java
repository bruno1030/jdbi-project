package com.bruno.jdbiproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Student {

    private int id;
    private String name;
    private int age;
    private Stage stage;
    private Date registrationDate;

}
