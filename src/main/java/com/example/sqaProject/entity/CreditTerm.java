package com.example.sqaProject.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "credit_term")
public class CreditTerm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="credit_term_id")
    private int creditId;
	
	@Column(name="interest_rate",nullable = false)
	private float interestRate;
	
	@Column(name="number_of_month",nullable = false)
	private int numberOfMonth;
	
	@Column(name="status",nullable = false)
	private String status;
	
	@OneToMany(mappedBy = "cTerm")
    private List<Credit> credits=new ArrayList<>();
}
