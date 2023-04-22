package com.example.sqaProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sqaProject.entity.Credit;

public interface CreditRepository extends JpaRepository<Credit, Integer>{
		List<Credit> findByBorrowDay(String date);
}
