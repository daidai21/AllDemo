package com.example.demo.converter;

import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarConverter {
    CarConverter INSTANCE = Mappers.getMapper(CarConverter.class);

    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDTO carToCarDto(Car car);
}
