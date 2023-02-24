package com.example.demo.Day1;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class  Welcome{
    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome String Boot!";
    }
}