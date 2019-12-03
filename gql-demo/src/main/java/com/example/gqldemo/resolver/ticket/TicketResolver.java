package com.example.gqldemo.resolver.ticket;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.gqldemo.dao.TicketDao;
import com.example.gqldemo.dao.UserDao;
import com.example.gqldemo.model.Ticket;
import com.example.gqldemo.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TicketResolver implements GraphQLResolver<Ticket> {
  @Resource
  private UserDao userDao;

  public User getUser(Ticket ticket) {
    return userDao.selectUserById(ticket.getCreatedBy());
  }
}
