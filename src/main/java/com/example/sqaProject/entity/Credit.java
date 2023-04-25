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
    @Column(name="credit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creditId;
    
    @Column(name="original_money")
    private int original_money;
    
    @Column(name="money")
    private int money;
    
    @Column(name="borrow_day")
    private String borrowDay;
    
    @Column(name="pay_day")
    private String payDay;
    
    @Column(name="mortgage")
    private String mortgage;
    
    @ManyToOne 
    @JoinColumn(name = "bank_account_number")
    private BankAccount bankAccountNumber;
    
    @ManyToOne
    @JoinColumn(name = "credit_term_id")
    private CreditTerm cTerm;    
    
    @Column(name="credit_status")
    private boolean status;
}
