package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.CreditTerm;
import com.example.sqaProject.repository.CreditTermRepository;
import com.example.sqaProject.service.ICreditTermService;

@Service
public class CreditTermService implements ICreditTermService{
	@Autowired
	private CreditTermRepository creditTermRepository;
	@Override
	public List<CreditTerm> findAll() {
		// TODO Auto-generated method stub
		return creditTermRepository.findAll();
	}
	@Override
	public CreditTerm findByCreditId(int cd) {
		// TODO Auto-generated method stub
		return creditTermRepository.findByCreditId(cd);
	}
	@Override
	public void save(CreditTerm creditTerm) {
		// TODO Auto-generated method stub
		creditTermRepository.save(creditTerm);
	}
	@Override
	public void delete(CreditTerm creditTerm) {
		// TODO Auto-generated method stub
		creditTermRepository.delete(creditTerm);
	}
	@Override
	public void deleleById(int id) {
		// TODO Auto-generated method stub
		creditTermRepository.deleteById(id);
	}

}
