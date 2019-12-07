package com.example.gqldemo.resolver.ticket;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.gqldemo.service.UserService;
import com.example.gqldemo.model.Ticket;
import com.example.gqldemo.model.User;
import graphql.schema.DataFetchingEnvironment;
import graphql.servlet.GraphQLContext;
import org.dataloader.DataLoader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class TicketResolver implements GraphQLResolver<Ticket> {
  @Resource
  private UserService userService;

//  public User getUser(Ticket ticket, DataFetchingEnvironment env) {
//    System.out.println(env.getSource().toString());
//    return userService.selectUserById(ticket.getCreatedBy());
//  }

  public CompletableFuture<User> getUser(Ticket ticket, DataFetchingEnvironment env) {
    DataLoader<String, User> dataloader = ((GraphQLContext) env.getContext())
            .getDataLoaderRegistry().get()
            .getDataLoader("userDataLoader");
    return dataloader.load(ticket.getCreatedBy());
  }
}
