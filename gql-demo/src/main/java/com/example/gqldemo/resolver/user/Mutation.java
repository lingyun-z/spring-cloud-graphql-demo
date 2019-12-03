package com.example.gqldemo.resolver.user;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.gqldemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
  private static final Logger logger = LoggerFactory.getLogger(Mutation.class);

  public User createUser(User user) {
    return user;
  }

  public User updataUserById(String id, User user) {
    return user;
  }

  public boolean deleteUser(String id) {
    return true;
  }
}
