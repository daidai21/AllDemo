package com.example.demo;

import com.example.demo.converter.MultiLevelConverter;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.Wife;

public class MultiLevelExample {
    public static void main(String[] args) {
        Student student = new Student("tom", 33);
        Wife wife = new Wife("jerry", 22);
        Teacher teacher = new Teacher("frank", 42, wife);
        System.out.println(student.toString() + "\n"
                + wife.toString() + "\n"
                + teacher.toString());

        StudentDTO studentDTO = MultiLevelConverter.INSTANCE.toDTO(student, teacher);
        System.out.println(studentDTO.toString());

        StudentDTO studentDTO2 = MultiLevelConverter.INSTANCE.to(student, teacher);
        System.out.println(studentDTO2.toString());

    }
}
