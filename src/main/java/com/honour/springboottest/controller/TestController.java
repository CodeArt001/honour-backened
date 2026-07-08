package com.honour.springboottest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/cephas")
    public String greet(){
        return "Good Morning Cephas";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Just greeting you";
    }
    
}
