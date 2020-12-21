package com.example.demo;

public class Application {
    /**
     * 实际使用
     * @param args
     */
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
