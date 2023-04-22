package com.example.sqaProject.service;

import java.util.List;

import com.example.sqaProject.entity.Credit;

public interface ICreditService {
	List<Credit> findAll();
	List<Credit> findByBorrowDay(String date);
}
