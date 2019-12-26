package com.kish.learning.kubeservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetUserResource {

    @GetMapping("/greet/{user}")
    public ResponseEntity<String> greetUser(@PathVariable("user")  String user){
            return ResponseEntity.ok(String.format("Hello %s ",user));
    }

}
