package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.Credit;
import com.example.sqaProject.repository.CreditRepository;
import com.example.sqaProject.service.ICreditService;
import org.springframework.scheduling.annotation.Scheduled;

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
        @Override
        @Scheduled(cron = "0 0 0 1 * *")
        public void autoUpdateMoney() {
            List<Credit> credits = creditRepository.findAll();
            for (Credit credit : credits) {
                if(credit.isStatus()) {
                    credit.setMoney((int) (credit.getMoney() * (credit.getCTerm().getInterestRate()/(100*12))));
                }
            }
        }
        @Override
        @Scheduled(cron = "0 0 12 * * *")
        public void autoUpdateMoneyByStatus() {
            List<Credit> credits = creditRepository.findAll();
            for (Credit credit : credits) {
                if(!credit.isStatus()) {
                    credit.setMoney(0);
                }
            }
        }
}
