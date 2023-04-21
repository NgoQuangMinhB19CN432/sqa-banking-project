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
@Table(name="saving_term")
public class SavingTerm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="saving_term_id")
    private int savingId;
	
	@Column(name="interest_rate", nullable=false)
	private float interestRate;
	
	@Column(name="number_of_month", nullable=false)
	private int numberOfMonth;
	
	@Column(name="status", nullable=false)
	private String status;
	
	@OneToMany(mappedBy = "sTerm")
    private List<Saving> savings=new ArrayList<>();

	public int getSavingId() {
		return savingId;
	}

	public void setSavingId(int savingId) {
		this.savingId = savingId;
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

	public List<Saving> getSavings() {
		return savings;
	}

	public void setSavings(List<Saving> savings) {
		this.savings = savings;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
