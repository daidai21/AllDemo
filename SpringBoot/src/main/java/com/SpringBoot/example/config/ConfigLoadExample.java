package com.SpringBoot.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// ref: https://github.com/crossoverJie/cim

@Component
public class ConfigLoadExample {
    // 未指定默认值
    @Value("${user.username}")
    public String username;

    // 指定默认值为“unknown”
    @Value("${projectName:unknown}")
    public String projectName;


}
