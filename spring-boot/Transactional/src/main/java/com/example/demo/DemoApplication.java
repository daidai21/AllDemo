package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@SpringBootApplication
@RestController
public class DemoApplication {

    @Autowired
    private DemoManager demoManager;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/success")
    public String success() {
        // 全部成功
        System.out.println("===== success =====");
        demoManager.read();
        return "success";
    }

    @GetMapping("/fail")
    public String fail() {
        // 部分成功部分失败
        System.out.println("===== fail =====");
        demoManager.multiReadAndMultiInsert();
        return "fail";
    }
}
