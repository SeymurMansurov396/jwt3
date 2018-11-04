package com.example.polls.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

	@GetMapping("/test")
	public ResponseEntity<?> test1(){
		return new  ResponseEntity<>("test",HttpStatus.OK);
	}
	
	@GetMapping("/test2")
	public ResponseEntity<?> test2(){
		return new  ResponseEntity<>("test 2",HttpStatus.OK);
	}
	
	
	
}
