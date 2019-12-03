package com.example.ticketservice.service;

import com.example.ticketservice.entity.Ticket;

import java.util.List;

public interface TicketService {
  Ticket createTicket(Ticket ticket);

  int deleteTicketById(String id);

  Ticket updateTicket(Ticket ticket);

  Ticket selectTicketById(String id);

  List<Ticket> getAll();

  List<Ticket> selectTicketByUserId(String userId);
}
