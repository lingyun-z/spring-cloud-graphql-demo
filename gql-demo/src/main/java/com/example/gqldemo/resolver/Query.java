package com.example.gqldemo.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.gqldemo.service.TicketService;
import com.example.gqldemo.service.UserService;
import com.example.gqldemo.model.Ticket;
import com.example.gqldemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
  private final Logger logger = LoggerFactory.getLogger(Query.class);

  @Resource
  private UserService userService;

  @Resource
  private TicketService ticketService;

  public List<User> allUsers() {
    return userService.getAllUsers();
  }

  public User selectUserById(String id) {
    return userService.selectUserById(id);
  }

  public Ticket selectTicketById(String id) {
    return ticketService.selecteTicketById(id);
  }

  public List<Ticket> getAllTicket() {
    logger.info("getAllTicket");
    return ticketService.getAllTicket();
  }
}