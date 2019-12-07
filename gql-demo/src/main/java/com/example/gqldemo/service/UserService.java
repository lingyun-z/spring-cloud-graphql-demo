package com.example.gqldemo.service;

import com.example.gqldemo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "user-service", path = "/api/user")
public interface UserService {
  @GetMapping(value = "/api/user/{id}")
  User selectUserById(@PathVariable("id") String id);

  @GetMapping(value = "/api/user")
  List<User> getAllUsers();

  @PostMapping(value = "/api/user/batch")
  List<User> getUserByIds(@RequestBody List<String> ids);

  @PostMapping(value = "/api/user")
  User addUser(@RequestBody User user);
}
