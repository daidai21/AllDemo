package com.example.demo;

// TODO: 没有调试运行
// https://snailclimb.gitee.io/javaguide/#/docs/java/basic/java-proxy?id=_31-jdk-%e5%8a%a8%e6%80%81%e4%bb%a3%e7%90%86%e6%9c%ba%e5%88%b6
public class App {
    public static void main(String[] args) {
        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("java");
    }
}
