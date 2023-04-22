package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.Credit;
import com.example.sqaProject.entity.CreditTerm;
import com.example.sqaProject.repository.CreditTermRepository;
import com.example.sqaProject.service.ICreditTermService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CreditTermService implements ICreditTermService{
	private JdbcTemplate jdbc;
	@Autowired
	public CreditTermService(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	@Autowired
	private CreditTermRepository creditTermRepository;
	@Autowired 
	private CreditService creditService;
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
	public void deleleByCreditId(int id) {
		// TODO Auto-generated method stub
		creditTermRepository.deleteByCreditId(id);;
	}
	@Override
	public boolean checkDeleteCreditTerm(CreditTerm sv) {
		// TODO Auto-generated method stub
				List<Credit> lsa= creditService.findAll();
				for(Credit s:lsa) {
					if(s.getCTerm().getCreditId()==sv.getCreditId()) {
						return false;
					}
				}
				
				return true;
	}
	@Override
	public int update(int creaditId, float interest, int numberOfMonth, String status, int sv2) {
		return jdbc.update("update credit_term set credit_term_id=?, interest_rate=? , number_of_month=?, status=? where credit_term_id=?", creaditId,interest,numberOfMonth,status,creaditId);
	}

}
