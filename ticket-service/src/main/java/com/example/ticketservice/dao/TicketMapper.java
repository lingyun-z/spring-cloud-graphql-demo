package com.example.ticketservice.dao;

import com.example.ticketservice.entity.Ticket;

import java.util.List;

public interface TicketMapper {
  int createTicket(Ticket ticket);

  int deleteTicketById(String id);

  int updateTicket(Ticket ticket);

  Ticket selectTicketById(String id);

  List<Ticket> getAll();

  List<Ticket> selectTicketByUserId(String userId);
}
