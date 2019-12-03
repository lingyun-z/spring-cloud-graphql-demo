package com.example.ticketservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi")
public interface HelloWorldService {
    @PostMapping(value = "/api/hi")
    String hello(@RequestParam(value = "name") String name);
}
