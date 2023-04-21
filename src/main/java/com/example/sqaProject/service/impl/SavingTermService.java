package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.SavingTerm;
import com.example.sqaProject.repository.SavingTermRepository;
import com.example.sqaProject.service.ISavingTermService;

@Service
public class SavingTermService implements ISavingTermService{
	@Autowired
	private SavingTermRepository savingTermRepository;
	@Override
	public List<SavingTerm> findAll() {
		// TODO Auto-generated method stub
		return savingTermRepository.findAll();
	}
	@Override
	public SavingTerm findBySavingId(int sa) {
		// TODO Auto-generated method stub
		return savingTermRepository.findBySavingId(sa);
	}
	@Override
	public void save(SavingTerm savingTerm) {
		// TODO Auto-generated method stub
		savingTermRepository.save(savingTerm);
		
	}
	@Override
	public void delete(SavingTerm savingTerm) {
		// TODO Auto-generated method stub
		savingTermRepository.delete(savingTerm);
	}

}
