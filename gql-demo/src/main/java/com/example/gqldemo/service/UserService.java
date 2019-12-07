package com.example.gqldemo.service;

import com.example.gqldemo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "user-service")
public interface UserService {
  @GetMapping(value = "/api/user/{id}")
  User selectUserById(@PathVariable("id") String id);

  @GetMapping(value = "/api/user")
  List<User> getAllUsers();

  @GetMapping(value = "/api/user/batch")
  List<User> getUserByIds(@RequestBody List<String> ids);
}
