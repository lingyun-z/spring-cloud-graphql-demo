package com.example.gqldemo.dao;

import com.example.gqldemo.model.Ticket;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "ticket-service")
public interface TicketDao {
  @GetMapping("/api/ticket")
  List<Ticket> getAllTicket();

  @GetMapping("/api/ticket/{id}")
  Ticket selecteTicketById(@PathVariable("id") String id);

  @GetMapping("/api/ticket/user-ticket/{user-id}")
  List<Ticket> selecteTicketByUserId(@PathVariable("user-id") String userId);
}
