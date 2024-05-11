package com.kali.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kali.binding.Customer;

@RestController
public class CustomerRestController {
	
	@GetMapping(value = "/customer", produces = "application/json")
	public ResponseEntity<Customer> getcustomer(){
		Customer c=new Customer(1, "kali", "kali@gmail.com");
		return new ResponseEntity<>(c, HttpStatus.OK);
	}
	
	@GetMapping(value = "/customers", produces = "application/json")
	public ResponseEntity<List<Customer>> getcustomers(){
		Customer c1=new Customer(1, "kali", "kali@gmail.com");
		Customer c2=new Customer(2, "Smith", "smith@gmail.com");
		Customer c3=new Customer(3, "Dhanush", "dhanush@gmail.com");
		List<Customer> list = Arrays.asList(c1,c2,c3);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/customer", 
			consumes = "application/json",
			produces = "text/plain")
	public ResponseEntity<String> createCustomer(@RequestBody Customer c){
		System.out.println(c);
		//insert into db
		return new ResponseEntity<>("Customer Saved", HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/customer/{cid}", produces = "text/plain")
	public ResponseEntity<String> deleteCustomer(Integer cid){
		//delete customer
		return new ResponseEntity<>("Customer Deleted", HttpStatus.OK);
	}
	
	@PutMapping(value="/customer",
			consumes = "application/json",
			produces = "text/plain")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer c){
		//update customer in db
		return new ResponseEntity<>("Customer Updated", HttpStatus.OK);
	}

}
