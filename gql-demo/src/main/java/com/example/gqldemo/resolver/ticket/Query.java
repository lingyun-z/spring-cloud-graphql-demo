package com.example.gqldemo.resolver.ticket;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.gqldemo.dao.TicketDao;
import com.example.gqldemo.dao.UserDao;
import com.example.gqldemo.model.Ticket;

import javax.annotation.Resource;

public class Query implements GraphQLQueryResolver {
  @Resource
  UserDao userDao;

  @Resource
  TicketDao ticketDao;

  public Ticket selectTicketById(String id) {
    Ticket ticket = ticketDao.selecteTicketById(id);
    ticket.setUser(userDao.selectUserById(ticket.getCreatedBy()));
    return ticket;
  }
}
