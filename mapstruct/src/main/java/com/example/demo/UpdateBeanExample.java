package com.example.demo;

import com.example.demo.converter.UpdateBeanConverter;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;

public class UpdateBeanExample {
    public static void main(String[] args) {
        Student student = new Student("tom", 1);
        StudentDTO studentDTO = new StudentDTO("jerry", 2);
        UpdateBeanConverter.INSTANCE.toDTO(student, studentDTO);
        System.out.println(studentDTO);
    }
}
