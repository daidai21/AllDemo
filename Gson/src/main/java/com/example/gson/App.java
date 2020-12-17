package com.example.gson;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws NullPointerException {
        Gson gson = new Gson();

        // 基本数据类型的解析
        int i = gson.fromJson("100", int.class);
        System.out.println(i);
        double d = gson.fromJson("\"99.99\"", double.class);
        System.out.println(d);
        boolean b = gson.fromJson("true", boolean.class);
        System.out.println(b);
        String str = gson.fromJson("String", String.class);
        System.out.println(str);

        // 基本数据类型的生成
        String jsonNumber = gson.toJson(100);
        System.out.println(jsonNumber);
        String jsonBoolean = gson.toJson(false);
        System.out.println(jsonBoolean);
        String jsonString = gson.toJson("String");
        System.out.println(jsonString);

        // POJO类的生成与解析
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1, "blue");
        colours.put(2, "yellow");
        colours.put(3, "green");
        String output = gson.toJson(colours);
        System.out.println(output);
    }
}
