package com.example.sqaProject.service;

import java.util.List;

import com.example.sqaProject.entity.SavingTerm;

public interface ISavingTermService {
	List<SavingTerm> findAll();
	SavingTerm findBySavingId(int sa);
	void save(SavingTerm savingTerm);
	void delete(SavingTerm savingTerm);
	boolean checkDeleteSavingTerm(SavingTerm sv);
	void deleteBySavingId(int i);
	int update(int savingId,float interest,int numberOfMonth,String status,int sv2);
}
