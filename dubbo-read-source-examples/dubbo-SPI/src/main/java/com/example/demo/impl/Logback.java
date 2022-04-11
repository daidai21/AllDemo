package com.example.demo.impl;

import com.example.demo.Log;

public class Logback implements Log {

    @Override
    public void log(String info) {
        System.out.println("Logback:" + info);
    }

}
