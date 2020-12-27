package com.example.demo.lang3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ToStringBuilderExample {
    public static void main(String[] args) {
        Message message = new Message("tom", "jerry", "hello");
        System.out.println(ToStringBuilder.reflectionToString(message));
    }
}

@Getter
@Setter
@AllArgsConstructor
class Message {
    private String from;

    private String to;

    private String body;
}
