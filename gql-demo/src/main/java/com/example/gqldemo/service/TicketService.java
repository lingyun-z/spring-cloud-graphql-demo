package com.example.gqldemo.service;

import com.example.gqldemo.model.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "ticket-service", path = "/api/ticket")
public interface TicketService {
  @GetMapping
  List<Ticket> getAllTicket();

  @GetMapping("/{id}")
  Ticket selecteTicketById(@PathVariable("id") String id);

  @GetMapping("/user-ticket/{user-id}")
  List<Ticket> selecteTicketByUserId(@PathVariable("user-id") String userId);
}
