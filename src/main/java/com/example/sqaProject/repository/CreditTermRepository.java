package com.example.sqaProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sqaProject.entity.CreditTerm;

public interface CreditTermRepository extends JpaRepository<CreditTerm, Integer>{
			CreditTerm findByCreditId(int id);
			void deleteByCreditId(int id);
}
