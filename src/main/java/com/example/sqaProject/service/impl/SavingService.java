package com.example.sqaProject.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.Saving;
import com.example.sqaProject.repository.SavingRepository;
import com.example.sqaProject.service.ISavingService;
@Repository
@Service
public class SavingService implements ISavingService {
	@Autowired
	private SavingRepository savingRepository;
	@Override
	public List<Saving> findAll() {
		// TODO Auto-generated method stub
		return savingRepository.findAll();
	}
        @Override
        public List<Saving> findByToDate(String toDate) {
            return savingRepository.findByToDate(toDate);
        }
}
