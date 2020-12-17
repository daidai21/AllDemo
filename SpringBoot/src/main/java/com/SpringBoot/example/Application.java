package com.SpringBoot.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import com.SpringBoot.example.config.ConfigLoadExample;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        System.out.println("\n\n\n\n\n==================================================");
        ConfigLoadExample configLoadExample = new ConfigLoadExample();
        System.out.println(configLoadExample.username + configLoadExample.projectName);
    }
}
