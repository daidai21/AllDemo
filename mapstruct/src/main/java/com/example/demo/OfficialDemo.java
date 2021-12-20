package com.example.demo;

import com.example.demo.converter.CarConverter;
import com.example.demo.dto.CarDTO;
import com.example.demo.entity.Car;
import com.example.demo.enums.CarType;

public class OfficialDemo {
    public static void main(String[] args) {
        Car car = new Car("Morris", 5, CarType.SEDAN);

        System.out.println("car: " + car.toString());

        CarDTO carDto = CarConverter.INSTANCE.carToCarDto(car);

        System.out.println("carDto: " + carDto.toString());
    }
}
