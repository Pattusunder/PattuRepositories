package com.example.spring.mysql.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.mysql.api.dao.TicketDao;
import com.example.spring.mysql.api.model.Ticket;
@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	private TicketDao dao;
@PostMapping("/bookTickets")
	public String  bookTicket(List<Ticket> tickets) {
	 dao.saveAll(tickets);
    return "ticket booked : "+tickets.size();
	}
@GetMapping("/getTickets")
	public List<Ticket> getTickets(){
		return (List<Ticket>) dao.findAll();
	}
	
	}
		
	

