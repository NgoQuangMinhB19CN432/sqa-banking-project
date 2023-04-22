package com.example.sqaProject.service;

import java.util.List;

import com.example.sqaProject.entity.CreditTerm;

public interface ICreditTermService {
	List<CreditTerm> findAll();
	CreditTerm findByCreditId(int cd);
	void save(CreditTerm creditTerm);
	void delete(CreditTerm creditTerm);
	void deleleByCreditId(int id);
	boolean checkDeleteCreditTerm(CreditTerm sv);
	int update(int creaditId,float interest,int numberOfMonth,String status,int sv2);
}
