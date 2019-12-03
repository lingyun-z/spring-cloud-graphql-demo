package com.example.gqldemo.dao;

import com.example.gqldemo.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "user-service")
public interface UserDao {
  @GetMapping(value = "/api/user/{id}")
  User selectUserById(@PathVariable("id") String id);

  @GetMapping(value = "/api/user")
  List<User> getAllUsers();
}
