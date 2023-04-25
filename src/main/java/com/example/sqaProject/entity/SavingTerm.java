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
@Table(name="saving_term")
public class SavingTerm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="saving_term_id")
        private int savingId;
        
        @Column(name = "createdby")
	private String createdBy;
	@Column(name = "createddate")
	private String createdDate;
	@Column(name = "modifiedby")
	private String modifiedBy;
	@Column(name = "modifieddate")
	private String modifiedDate;
	
	@Column(name="interest_rate", nullable=false)
	private float interestRate;
	
	@Column(name="number_of_month", nullable=false)
	private int numberOfMonth;
	
	@Column(name="status", nullable=false)
	private String status;
	
	@OneToMany(mappedBy = "sTerm")
        private List<Saving> savings=new ArrayList<>();
}
