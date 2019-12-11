package com.example.gqldemo.service;

import com.example.gqldemo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-service", path = "/api/user")
public interface UserService {
  @GetMapping(value = "/{id}")
  User selectUserById(@PathVariable("id") String id);

  @GetMapping
  List<User> getAllUsers();

  @PostMapping(value = "/batch")
  List<User> getUserByIds(@RequestBody List<String> ids);

  @PostMapping
  User addUser(@RequestBody User user);
}
