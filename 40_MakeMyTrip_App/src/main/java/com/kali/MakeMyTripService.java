package com.kali;

import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.kali.binding.Passenger;
import com.kali.binding.Ticket;

import reactor.core.publisher.Mono;

public class MakeMyTripService {
	
	private final String BOOK_TICKET_URL= "http://localhost:8080/ticket";
	
	private final String GET_TICKETS_URL= "http://localhost:8080/tickets";

	public Mono<Ticket> bookTicket(Passenger p){
		//logic
		
		WebClient webClient = WebClient.create();
		
		return webClient.post()
				 .uri(BOOK_TICKET_URL)
				 .body(BodyInserters.fromValue(p))
				 .retrieve()
				 .bodyToMono(Ticket.class);
	}
	
	public Mono<Ticket[]> getAllTickets(){
		//logic to send get request
		WebClient webClient = WebClient.create();
		
		return webClient.get()
			     .uri(GET_TICKETS_URL)
			     .retrieve()
			     .bodyToMono(Ticket[].class);

	}
}
