package com.example.demo;

import lombok.NonNull;

public class NonNullExample {
    public static void main(String[] args) {
        inputNotNull("123");
        try {
            inputNotNull(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        outputNotNull("123");
        try {
            outputNotNull(null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private static void inputNotNull(@NonNull String name) {
        System.out.println("inputNotNull " + name);
    }

    // BUG: NotNull
    // lombok not support check return null.
    @NonNull
    private static String outputNotNull(String name) {
        System.out.println("outputNotNull " + name);
        return name;
    }
}
