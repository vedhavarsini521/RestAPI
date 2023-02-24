package com.example.demo.Day1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentName {
    private String studentName="IamNeo";
    @GetMapping("/name")
    public String getName(){
        return "Welcome "+studentName+"!";
    }
}