package com.example.userservice.service;

import com.example.userservice.entity.User;

import java.util.List;

public interface UserService {
  User createUser(User user);

  int deleteUserById(String id);

  User updateUser(User user);

  User selectUserById(String id);

  List<User> getUserByIds(List<String> ids);

  List<User> getAll();
}
