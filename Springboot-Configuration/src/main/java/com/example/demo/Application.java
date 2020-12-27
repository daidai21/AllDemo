package com.example.demo;

import com.example.demo.config.ConfigurationPropertiesExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan("com.example.demo.controller")
@EnableConfigurationProperties(ConfigurationPropertiesExample.class)
public class Application {
    public static void main(String[] args) {
        // Thread.currentThread().setName("Application");
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
