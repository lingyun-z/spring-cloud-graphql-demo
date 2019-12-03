package com.example.ticketservice.controller;

import com.example.ticketservice.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @Autowired
    HelloWorldService hello;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam(value = "name") String name) {
        return hello.hello(name);
    }
}
