package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    private String teacherName;
    private Integer teacherAge;
    private Wife wife;
}
