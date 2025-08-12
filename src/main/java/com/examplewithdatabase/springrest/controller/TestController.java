package com.examplewithdatabase.springrest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @PostMapping
    public String testPost() {
        return "POST Works!";
    }
    
    @PutMapping
    public String testPut() {
        return "PUT Works!";
    }
    
    @DeleteMapping
    public String testDelete() {
        return "DELETE Works!";
    }
}