package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.Credit;
import com.example.sqaProject.repository.CreditRepository;
import com.example.sqaProject.service.ICreditService;

@Service
public class CreditService implements ICreditService {
	@Autowired
	private CreditRepository creditRepository;
	@Override
	public List<Credit> findAll() {
		// TODO Auto-generated method stub
		return creditRepository.findAll() ;
	}
	@Override
	public List<Credit> findByBorrowDay(String date) {
		// TODO Auto-generated method stub
		return creditRepository.findByBorrowDay(date);
	}

}
