package com.example.demo;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InsertRepository {

    public void multiInsert(List<DemoDAO> demoDAOS) {
        System.out.println("-> InsertRepository.multiInsert()");
        throw new RuntimeException();
    }
}
