package com.kali.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kali.request.PassengerData;
import com.kali.response.TicketData;
import com.kali.service.TicketDetailsService;

@RestController
public class TicketBookingController {
	
	@Autowired
	private TicketDetailsService ticketDlsService;
	
	@PostMapping(value="/book-ticket",
			consumes = "application/json",
			produces = "application/json")
	public ResponseEntity<TicketData> savePassengerData(@RequestBody PassengerData passegerData){
		TicketData data = ticketDlsService.savePassengerData(passegerData);
		return new ResponseEntity<>(data, HttpStatus.CREATED);
	}
	
	@GetMapping(value="/get-ticket/{ticket_id}",
			produces = "application/json")
	public ResponseEntity<TicketData> getTicket(@PathVariable Integer ticket_id){
		TicketData data = ticketDlsService.getById(ticket_id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
	@GetMapping(value="/get-tickets",
			produces = "application/json")
	public ResponseEntity<List<TicketData>> getAllCourses(){
		List<TicketData> allTickets= ticketDlsService.getAllTickets();
		return new ResponseEntity<>(allTickets, HttpStatus.OK);
	}


}
