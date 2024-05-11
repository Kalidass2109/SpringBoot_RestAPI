package com.kali.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {

	@GetMapping("/welcome")
	public String getWelcomeMsg(@RequestParam("name") String name) {
		String str=name+", Welcome to REST API";
		return str;
	}
	
	@GetMapping("/greet/{name}")
	public String getGreetMsg(@PathVariable("name") String name) {
		String str=name+", Good Morning..!!";
		return str;
	}
	
	@PostMapping("/date")
	public String getDate() {
		LocalDate now = LocalDate.now();
		return String.valueOf(now);
	}
	
	//we can let consumer know what its returning by produces
	//if we wnat mention other attribute like produces, we have to define "value" for url
	@GetMapping(value="/msg", produces = "text/plain")
	public ResponseEntity<String> getMsg() { //ResponseEntity is container to store the response data, what response body and status code to send we can set 
		String msg="Welcome to Programing World..";
		
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
}
