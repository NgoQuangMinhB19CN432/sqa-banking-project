package com.example.sqaProject.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.sqaProject.entity.BankAccount;
import com.example.sqaProject.entity.Saving;
import com.example.sqaProject.entity.SavingTerm;
import com.example.sqaProject.repository.SavingRepository;
import com.example.sqaProject.service.ISavingService;
@Repository
@Service
public class SavingService implements ISavingService {
	private JdbcTemplate jdbc;
	@Autowired
	public SavingService(JdbcTemplate jdbc) {
		// TODO Auto-generated constructor stub
		this.jdbc=jdbc;
	}
	@Autowired
	private SavingRepository savingRepository;
	@Override
	public List<Saving> findAll() {
		// TODO Auto-generated method stub
		return savingRepository.findAll();
	}

	@Override
	public List<Saving> getBillByDate(String day1, String day2) {
		String sql="select saving_id, kind_of_profit,original_money,to_date,saving.bank_account_number, bank_account.id,bank_account.fullname,saving_term.interest_rate,saving_term.number_of_month,saving_term.saving_term_id from saving"+" INNER JOIN bank_account ON bank_account.id=saving.bank_account_number"+" INNER JOIN saving_term ON saving_term.saving_term_id=saving.saving_term_id"+" WHERE to_date BETWEEN ? AND ?";
		return (List<Saving>) jdbc.query(sql,this::mapRowToSaving, day1, day2);
	}
	
	private Saving mapRowToSaving(ResultSet rs, int rowNum) throws SQLException {
		Saving saving = new Saving();
		saving.setSavingId(rs.getInt("saving_id"));
		saving.setKindOfProfit(rs.getString("kind_of_profit"));
		saving.setOriginalMoney(rs.getInt("original_money"));
		saving.setToDate(rs.getString("to_date"));
		BankAccount ba= new BankAccount();
		ba.setId(rs.getInt("bank_account_number"));
		ba.setFullname(rs.getString("fullname"));
		saving.setBankAccountNumber(ba);
		SavingTerm st= new SavingTerm();
		st.setSavingId(rs.getInt("saving_term_id"));
		st.setInterestRate(rs.getFloat("interest_rate"));
		st.setNumberOfMonth(rs.getInt("number_Of_Month"));
		saving.setSTerm(st);
		return saving;

	}

	@Override
	public List<Saving> findAllByDate(String date) {
		// TODO Auto-generated method stub
		return savingRepository.findByToDate(date);
	}
	
}
