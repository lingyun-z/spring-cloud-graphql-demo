package com.example.gqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.gqldemo.model.User;
import org.springframework.stereotype.Component;

@Component
public class Mutation implements GraphQLMutationResolver {
  public User addUser(User user) {
    return new User();
  }
}
