package com.example.sqaProject.service;

import java.util.List;

import com.example.sqaProject.entity.Saving;

public interface ISavingService {
	List<Saving> findAll();
	List<Saving> getBillByDate(String day1, String day2);
	List<Saving> findAllByDate(String date);
}
