package com.example.demo;

import com.example.demo.DemoService;


public class DemoServiceImpl implements DemoService {
    public String sayHello(String name) {
        return "Hello " + name;
    }
}