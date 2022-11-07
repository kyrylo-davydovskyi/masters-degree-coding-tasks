package com.davydovskyi.study.lab1.dao;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String dateOfBirth;
}
