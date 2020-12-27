package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@PropertySource("classpath:PropertySourceExample-config.yml")
public class PropertySourceExample {
    @Value("${stringValue}")
    private String stringValue;

    @Override
    public String toString() {
        return "PropertySourceExample{" +
                "stringValue='" + stringValue + '\'' +
                '}';
    }
}
