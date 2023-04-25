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
    @Column(name="saving_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int savingId;
    
    @Column(name="to_date")
    private String toDate;
    
    @Column(name="original_money")
    private int originalMoney;
    
    @Column(name="result_money")
    private int resultMoney;
    
    @Column(name="kind_of_profit")
    private String kindOfProfit;
    
    @ManyToOne 
    @JoinColumn(name ="bank_account_number")
    private BankAccount bankAccountNumber;
    
    @ManyToOne 
    @JoinColumn(name = "saving_term_id")
    private SavingTerm sTerm;
    
    @Column(name="saving_status")
    private boolean status;
}
