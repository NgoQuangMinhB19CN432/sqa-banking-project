package com.example.sqaProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.Saving;
import com.example.sqaProject.entity.SavingTerm;
import com.example.sqaProject.repository.SavingTermRepository;
import com.example.sqaProject.service.ISavingTermService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SavingTermService implements ISavingTermService{
	private JdbcTemplate jdbc;
	@Autowired
	public SavingTermService(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}
	@Autowired
	private SavingTermRepository savingTermRepository;
	
	@Autowired
	private SavingService savingService;
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
	@Override
	public boolean checkDeleteSavingTerm(SavingTerm sv) {
		// TODO Auto-generated method stub
		List<Saving> lsa= savingService.findAll();
		for(Saving s:lsa) {
			if(s.getSTerm().getSavingId()==sv.getSavingId()) {
				return false;
			}
		}
		
		return true;
	}
	@Override
	public void deleteBySavingId(int i) {
		// TODO Auto-generated method stub
		savingTermRepository.deleteBySavingId(i);
	}
	@Override
	public int update(int savingId, float interest, int numberOfMonth, String status,String mBy,String mDate, int sv2) {
		// TODO Auto-generated method stub
		return jdbc.update("update saving_term set saving_term_id=?, interest_rate=? , number_of_month=?, status=?, modifiedby=?,modifieddate=? where saving_term_id=?", savingId,interest,numberOfMonth,status,mBy,mDate,savingId);
	}

}
