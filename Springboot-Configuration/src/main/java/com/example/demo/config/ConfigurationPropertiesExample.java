package com.example.demo.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ConfigurationProperties(prefix = "prefixName")
@Component
public class ConfigurationPropertiesExample {
    private String stringValue;

    @Override
    public String toString() {
        return "ConfigurationPropertiesExample{" +
                "stringValue='" + stringValue + '\'' +
                '}';
    }
}
