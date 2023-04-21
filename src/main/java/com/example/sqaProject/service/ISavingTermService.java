package com.example.sqaProject.service;

import com.example.sqaProject.entity.SavingTerm;
import java.util.List;

public interface ISavingTermService {
	List<SavingTerm> findAll();
	SavingTerm findBySavingId(int sa);
	void save(SavingTerm savingTerm);
	void delete(SavingTerm savingTerm);
}
