package com.example.demo.converter;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UpdateBeanConverter {
    UpdateBeanConverter INSTANCE = Mappers.getMapper(UpdateBeanConverter.class);

    void toDTO(Student student,
               @MappingTarget StudentDTO studentDTO);
}
