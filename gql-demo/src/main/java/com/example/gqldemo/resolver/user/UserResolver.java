package com.example.gqldemo.resolver.user;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.gqldemo.service.TicketService;
import com.example.gqldemo.model.Ticket;
import com.example.gqldemo.model.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {

  @Resource
  private TicketService ticketService;

  public UserResolver() {
  }

  public List<Ticket> getTickets(User user) {
    return ticketService.selecteTicketByUserId(user.getId());
  }
}
