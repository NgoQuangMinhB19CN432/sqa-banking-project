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
@Table(name = "credit")
@Getter
@Setter
public class Credit {
    DecimalFormat formatter = new DecimalFormat("#,###.00");
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int creditId;
    
    @Column(name="money")
    private float money;
    public String formattedMoney;
    
    @Column(name="borrowDay")
    private String borrowDay;
    
    @Column(name="payDay")
    private String payDay;  
    
    @Column(name="mortgage")
    private String mortgage;
    
    @ManyToOne 
    @JoinColumn(name = "bankAccountNumber")
    private BankAccount bankAccount;
    
    @ManyToOne
    @JoinColumn(name = "creditTerm_id")
    private CreditTerm cTerm; 
    
    @Column(name="status")
    private int status;
}
