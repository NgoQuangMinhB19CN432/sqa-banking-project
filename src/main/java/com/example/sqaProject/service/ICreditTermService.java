package com.example.sqaProject.service;

import com.example.sqaProject.entity.CreditTerm;
import java.util.List;

public interface ICreditTermService {
	List<CreditTerm> findAll();
	CreditTerm findByCreditId(int cd);
	void save(CreditTerm creditTerm);
	void delete(CreditTerm creditTerm);
	void deleleById(int id);
}
