package com.example.sqaProject.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.text.DecimalFormat;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "saving")
@Getter
@Setter
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int savingId;
    
    @Column(name="toDate")
    private String toDate;
    
    @Column(name="originalMoney")
    private float originalMoney;
    private String formattedOriginalMoney;
    
    @Column(name="kindOfProfit")
    private String kindOfProfit;
    
    @ManyToOne 
    @JoinColumn(name = "bankAccountNumber")
    private BankAccount bankAccount;
    
    @ManyToOne 
    @JoinColumn(name = "saving_term_id")
    private SavingTerm sTerm;
    
    @JoinColumn(name = "status")
    private int status;
}
