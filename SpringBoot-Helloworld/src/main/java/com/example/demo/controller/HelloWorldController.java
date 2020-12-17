package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.PropertyParamTest;

@RestController
public class HelloWorldController {
    @RequestMapping("/helloworld")
    public String helloWorld() {
        return "hello world";
    }

    @RequestMapping("/testConfig")
    public String testConfig() {
        return testConfig.toString();
    }

    @Value("${test.config}")
    private Integer testConfig;
}
