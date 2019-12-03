package com.example.gqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.gqldemo.dao.TicketDao;
import com.example.gqldemo.dao.UserDao;
import com.example.gqldemo.model.Ticket;
import com.example.gqldemo.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
  @Resource
  private UserDao userDao;

  @Resource
  private TicketDao ticketDao;

  public List<User> allUsers() {
    return userDao.getAllUsers();
  }

  public User selectUserById(String id) {
    return userDao.selectUserById(id);
  }

  public Ticket selectTicketById(String id) {
    return ticketDao.selecteTicketById(id);
  }
}