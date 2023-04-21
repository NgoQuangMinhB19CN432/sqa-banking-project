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

@Entity
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

	public int getCreditId() {
		return creditId;
	}

	public void setCreditId(int creditId) {
		this.creditId = creditId;
	}

	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}

	public int getNumberOfMonth() {
		return numberOfMonth;
	}

	public void setNumberOfMonth(int numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
