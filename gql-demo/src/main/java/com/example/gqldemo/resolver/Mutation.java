package com.example.gqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.gqldemo.model.User;
import com.example.gqldemo.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Mutation implements GraphQLMutationResolver {
  @Resource
  private UserService userService;

  public User addUser(User user) {
    return userService.addUser(user);
  }
}
