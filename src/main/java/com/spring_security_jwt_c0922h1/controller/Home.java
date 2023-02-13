package com.spring_security_jwt_c0922h1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping("/home")
    public String home(){
        return "hello";
    }
}
