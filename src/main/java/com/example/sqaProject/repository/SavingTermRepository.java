package com.example.sqaProject.repository;

import com.example.sqaProject.entity.SavingTerm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavingTermRepository extends JpaRepository<SavingTerm, Integer>{
		SavingTerm findBySavingId(int sa);
}
