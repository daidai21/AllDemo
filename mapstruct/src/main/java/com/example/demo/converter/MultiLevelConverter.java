package com.example.demo.converter;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MultiLevelConverter {
    MultiLevelConverter INSTANCE = Mappers.getMapper(MultiLevelConverter.class);

    @Mappings({
            @Mapping(source = "teacher.wife.name", target = "name"),
            @Mapping(source = "student.age", target = "age")
    })
    StudentDTO toDTO(Student student, Teacher teacher);

    @Mapping(source = "teacher.wife.name", target = "name")
    @Mapping(source = "student.age", target = "age")
    StudentDTO to(Student student, Teacher teacher);
}
