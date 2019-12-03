package com.example.gqldemo.resolver.user;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.gqldemo.dao.TicketDao;
import com.example.gqldemo.dao.UserDao;
import com.example.gqldemo.model.Ticket;
import com.example.gqldemo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {

  @Resource
  private TicketDao ticketDao;

  public List<Ticket> getTickets(User user) {
    return ticketDao.selecteTicketByUserId(user.getId());
  }
}
