package com.kali.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kali.response.Product;
import com.kali.service.ProductService;

import reactor.core.publisher.Mono;

@RestController
public class ProductRestController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/product")
	public ResponseEntity<Mono<Product>> getProduct(){
		Mono<Product> product = service.getProductNew();
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	

}
