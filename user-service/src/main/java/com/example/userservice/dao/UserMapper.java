package com.example.userservice.dao;

import com.example.userservice.entity.User;

import java.util.List;

public interface UserMapper {
  int createUser(User user);

  int deleteUserById(String id);

  int updateUser(User user);

  User selectUserById(String id);

  List<User> getAll();
}
