package com.kali.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.kali.response.Product;

import reactor.core.publisher.Mono;

@Service
public class ProductService {
	
	public Mono<String> getProduct() {
		String apiUrl="https://api.restful-api.dev/objects/1";
		
		//getting webclient impl class obj
		WebClient webClient= WebClient.create(); //here We can't create object as webclient is interface, so, creating object by using factory method 
		
		Mono<String> bodyToMono = webClient.get() //send GET req
				 .uri(apiUrl) //provider url
				 .retrieve() //retrieve the response body
				 .bodyToMono(String.class); //bodyToMono represents whatever response getting convert that response into string variable
				// .block(); //making synchronous
		
		//System.out.println(response);
		return bodyToMono;
	}
	
	public Mono<Product> getProductNew() {
		String apiUrl="https://api.restful-api.dev/objects/1";
		WebClient webClient= WebClient.create(); 
		
		return webClient.get()
				 .uri(apiUrl)
				 .retrieve()
				 .bodyToMono(Product.class);
	}

}
