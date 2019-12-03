package com.example.gqldemo.resolver.user;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.gqldemo.dao.UserDao;
import com.example.gqldemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
  private static final Logger logger = LoggerFactory.getLogger(Query.class);

  @Autowired
  private UserDao userDao;

  public List<User> allUsers() {
    return userDao.getAllUsers();
  }

  public User selectUserById(String id) {
    logger.info("select user id={}", id);
    return userDao.selectUserById(id);
  }
}
