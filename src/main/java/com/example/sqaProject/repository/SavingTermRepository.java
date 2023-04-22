package com.example.sqaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sqaProject.entity.SavingTerm;

public interface SavingTermRepository extends JpaRepository<SavingTerm, Integer>{
		SavingTerm findBySavingId(int sa);
		void deleteBySavingId(int i);
}
