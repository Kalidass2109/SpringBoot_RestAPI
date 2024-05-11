package com.kali.service;

import java.util.List;

import com.kali.request.PassengerData;
import com.kali.response.TicketData;

public interface TicketDetailsService {

	public TicketData savePassengerData(PassengerData passenger);
	
	public TicketData getById(Integer ticketId);
	
	public List<TicketData> getAllTickets();
	
	public String deleteById(Integer ticketId);
}
