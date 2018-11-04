package com.example.polls.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.polls.model.Operator;
import com.example.polls.repository.OperatorRepository;

@Service
public class OperatorService {

	@Autowired
	private OperatorRepository operatorRepository;
	public Operator findByUsername(String username) {
		return operatorRepository.findByUsername(username);
	}
	
	public Operator save(Operator o) {
		return operatorRepository.save(o);
	}
}
