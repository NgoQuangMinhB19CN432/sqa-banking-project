package com.example.sqaProject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sqaProject.entity.Saving;

public interface SavingRepository extends JpaRepository<Saving, Integer> {
	List<Saving> findByToDate(String date);
}
