package com.example.testawsservices.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/test")
public class ExampleController {

    @GetMapping
    public String getTest() {
        log.info("Test get info.");
        return "{\"key\": \"This is a test with spring boot and docker.\"}";
    }

    @GetMapping("/fibonacci/{number}")
    public String getFibonacciSerie(@PathVariable int number) {
        int array [] = new int[number];
        for (int i = 0; i < number; i++) {
            if(i == 0) {
                array[i] = 1;
                System.out.print(array[i] + " ");
            } else if(i == 1) {
                array[i] = 1;
                System.out.print(array[i] + " ");
            } else {
                array[i] = array[i - 1] + array[i - 2];
                System.out.print(array[i] + " ");
            }
        }

        return "{\"result\": " + Arrays.stream(array).mapToObj(n->String.valueOf(n)).collect(Collectors.toList()) + "}";
    }

    @GetMapping("/hello")
    public String hello() {
        return "123";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "123";
    }

}
