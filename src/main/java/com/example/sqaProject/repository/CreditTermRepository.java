package com.example.sqaProject.repository;

import com.example.sqaProject.entity.CreditTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditTermRepository extends JpaRepository<CreditTerm, Integer>{
			CreditTerm findByCreditId(int id);
}
