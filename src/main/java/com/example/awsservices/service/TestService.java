package com.example.testawsservices.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class TestService {

    @Value("${profiles.name}")
    private String nane;

    @PostConstruct
    public void init() {
        log.info("The name is: " + nane);
    }

}
