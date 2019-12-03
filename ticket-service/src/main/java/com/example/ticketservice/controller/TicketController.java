package com.example.ticketservice.controller;

import com.example.ticketservice.entity.Ticket;
import com.example.ticketservice.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
  private final Logger logger = LoggerFactory.getLogger(TicketController.class);

  @Resource
  private TicketService ticketService;

  @GetMapping("/{id}")
  public ResponseEntity<Ticket> getTicketById(@PathVariable("id") String id) {
    Ticket ticket = null;
    try {
      ticket = ticketService.selectTicketById(id);
      logger.info("getTicketById id: {}", id);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(ticket, HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<List<Ticket>> getAllTickets() {
    logger.info("getAllTickets");
    List<Ticket> tickets = null;
    try {
      tickets = ticketService.getAll();
      logger.info("getAllTickets");
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    return new ResponseEntity<>(tickets, HttpStatus.OK);
  }

  @GetMapping("/user-ticket/{user-id}")
  public ResponseEntity<List<Ticket>> selectTicketByUserId(@PathVariable("user-id") String userId) {
    List<Ticket> result = null;
    try {
      result = ticketService.selectTicketByUserId(userId);
      logger.info("selectTicketByUserId user-id: {}", userId);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
    Ticket retValue = null;
    try {
      retValue = ticketService.createTicket(ticket);
      logger.info("createTicket ticket: {}", ticket);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(retValue, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deteteTicketById(@PathVariable("id") String id) {
    HttpStatus retStatus = HttpStatus.OK;
    try{
      if (ticketService.deleteTicketById(id) == 0) {
        retStatus = HttpStatus.BAD_REQUEST;
        logger.info("deteteTicketById id: {}", id);
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(retStatus);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Ticket> updateTicket(@PathVariable("id") String id, @RequestBody Ticket ticket) {
    Ticket retValue = null;
    try{
      ticket.setId(id);
      retValue = ticketService.updateTicket(ticket);
      logger.info("updateTicket id: {} ticket: {}", id, ticket);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    return new ResponseEntity<>(retValue, HttpStatus.OK);
  }
}
