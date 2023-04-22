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
@Table(name = "credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creditId;
    
    @Column(name="money")
    private float money;
    
    @Column(name="borrowDay")
    private String borrowDay;
    
    @Column(name="payDay")
    private String payDay;
    
    @Column(name="mortgage")
    private String mortgage;
    
    @ManyToOne 
    @JoinColumn(name = "bankAccountNumber")
    private BankAccount bankAccountNumber;
    
    @ManyToOne
    @JoinColumn(name = "credit_term_id")
    private CreditTerm cTerm;    
}
