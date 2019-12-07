package com.example.userservice.dao;

import com.example.userservice.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
  int createUser(User user);

  int deleteUserById(String id);

  int updateUser(User user);

  User selectUserById(String id);

  List<User> getUserByIds(@Param("ids") List<String> ids);

  List<User> getAll();
}
