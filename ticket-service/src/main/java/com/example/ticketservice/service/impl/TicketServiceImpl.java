package com.example.ticketservice.service.impl;

import com.example.ticketservice.dao.TicketMapper;
import com.example.ticketservice.entity.Ticket;
import com.example.ticketservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
  @Autowired
  private TicketMapper ticketMapper;

  @Override
  public Ticket createTicket(Ticket ticket) {
    ticketMapper.createTicket(ticket);
    return ticket;
  }

  @Override
  public int deleteTicketById(String id) {
    return ticketMapper.deleteTicketById(id);
  }

  @Override
  public Ticket updateTicket(Ticket ticket) {
    if (ticketMapper.updateTicket(ticket) == 1) {
      return ticketMapper.selectTicketById(ticket.getId());
    }
    return null;
  }

  @Override
  public Ticket selectTicketById(String id) {
    return ticketMapper.selectTicketById(id);
  }

  @Override
  public List<Ticket> getAll() {
    return ticketMapper.getAll();
  }

  @Override
  public List<Ticket> selectTicketByUserId(String userId) {
    return ticketMapper.selectTicketByUserId(userId);
  }
}
