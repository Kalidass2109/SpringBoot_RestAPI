package com.kali.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kali.exception.productNotFoundException;

@RestController
public class ProductController {
	
	@GetMapping("/products/{id}")
	public ResponseEntity<String> getProduct(@PathVariable("id") Integer id) throws Exception{
		
		if(id==1) {
			//int i=19/0;
			return new ResponseEntity<>("Fetched Products", HttpStatus.OK);
		}else {
			throw new productNotFoundException("Invalid Id");
		}
		
	}

}
