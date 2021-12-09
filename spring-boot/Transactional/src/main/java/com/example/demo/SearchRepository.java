package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SearchRepository {

    public List<DemoDAO> multiSearch() {
        System.out.println("-> SearchRepository.multiSearch()");
        return null;
    }

    public DemoDAO search() {
        System.out.println("-> SearchRepository.search()");
        return null;
    }
}
