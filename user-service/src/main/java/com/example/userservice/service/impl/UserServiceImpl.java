package com.example.userservice.service.impl;

import com.example.userservice.dao.UserMapper;
import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public User createUser(User user) {
    userMapper.createUser(user);
    return user;
  }

  @Override
  public int deleteUserById(String id) {
    return userMapper.deleteUserById(id);
  }

  @Override
  public User updateUser(User user) {
    if (userMapper.updateUser(user) == 1) {
      return user;
    }
    return null;
  }

  @Override
  public User selectUserById(String id) {
    return userMapper.selectUserById(id);
  }

  @Override
  public List<User> getUserByIds(List<String> ids) {
    return userMapper.getUserByIds(ids);
  }

  @Override
  public List<User> getAll() {
    return userMapper.getAll();
  }
}
