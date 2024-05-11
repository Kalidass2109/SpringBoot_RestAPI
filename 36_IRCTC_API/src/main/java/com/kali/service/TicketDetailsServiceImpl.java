package com.kali.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kali.entity.TicketDetails;
import com.kali.entity.TicketDetailsRepo;
import com.kali.request.PassengerData;
import com.kali.response.TicketData;

@Service
public class TicketDetailsServiceImpl implements TicketDetailsService {

	@Autowired
	private TicketDetailsRepo ticketDtlsRepo;
	
	@Override
	public TicketData savePassengerData(PassengerData passenger) {
		TicketDetails details=new TicketDetails();
		details.setPassengerName(passenger.getPassengerName());
		details.setDob(passenger.getDob());
		details.setGender(passenger.getGender());
		details.setTrainNum(passenger.getTrainNum());
		details.setSource(passenger.getFrom());
		details.setDestination(passenger.getTo());
		details.setDoj(passenger.getDoj());
		details.setTicketStaus("Confirmed");
		
		TicketDetails savedDtls = ticketDtlsRepo.save(details);
		TicketData ticket=new TicketData();
		ticket.setTicketId(savedDtls.getTicketId());
		ticket.setTicketStaus(savedDtls.getTicketStaus());
		ticket.setTrainNum(savedDtls.getTrainNum());
		ticket.setFrom(savedDtls.getSource());
		ticket.setTo(savedDtls.getDestination());
		ticket.setDoj(savedDtls.getDoj());
		ticket.setPassengerName(savedDtls.getPassengerName());
		
		return ticket;
	}

	@Override
	public TicketData getById(Integer ticketId) {
		Optional<TicketDetails> findById = ticketDtlsRepo.findById(ticketId);
		
		if(findById.isPresent()) {
			
			TicketDetails savedDtls = findById.get();
			TicketData ticket=new TicketData();
			ticket.setTicketId(savedDtls.getTicketId());
			ticket.setTicketStaus(savedDtls.getTicketStaus());
			ticket.setTrainNum(savedDtls.getTrainNum());
			ticket.setFrom(savedDtls.getSource());
			ticket.setTo(savedDtls.getDestination());
			ticket.setDoj(savedDtls.getDoj());
			ticket.setPassengerName(savedDtls.getPassengerName());
			return ticket;
		}
		return null;
	}

	@Override
	public List<TicketData> getAllTickets() {
		List<TicketDetails> findAll = ticketDtlsRepo.findAll();
		List<TicketData> ticketList=new ArrayList<>();
		for(TicketDetails dtls:findAll) {
			
			TicketData ticket=new TicketData();
			ticket.setTicketId(dtls.getTicketId());
			ticket.setTicketStaus(dtls.getTicketStaus());
			ticket.setTrainNum(dtls.getTrainNum());
			ticket.setFrom(dtls.getSource());
			ticket.setTo(dtls.getDestination());
			ticket.setDoj(dtls.getDoj());
			ticket.setPassengerName(dtls.getPassengerName());
			
			ticketList.add(ticket);
		}
		return ticketList;
	}

	@Override
	public String deleteById(Integer ticketId) {
		
		return null;
	}

}
