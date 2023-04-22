package com.example.sqaProject.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "saving")
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int savingId;
    
    @Column(name="toDate")
    private String toDate;
    
    @Column(name="originalMoney")
    private float originalMoney;
    
    
    @Column(name="kindOfProfit")
    private String kindOfProfit;
    
    @ManyToOne 
    @JoinColumn(name ="bank_account_number")
    private BankAccount bankAccountNumber;
    
    @ManyToOne 
    @JoinColumn(name = "saving_term_id")
    private SavingTerm sTerm;
}
