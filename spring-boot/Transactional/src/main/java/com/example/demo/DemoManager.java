package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class DemoManager {

    @Autowired
    private InsertRepository insertRepository;

    @Autowired
    private SearchRepository searchRepository;

    @Transactional
    public DemoDAO read() {
        System.out.println("-> DemoManager.read()");
        return searchRepository.search();
    }

    @Transactional(rollbackFor = { RuntimeException.class, Exception.class })
    public void multiReadAndMultiInsert() {
        System.out.println("-> DemoManager.multiReadAndMultiInsert()");
        searchRepository.multiSearch();
        insertRepository.multiInsert(null);
    }
}
