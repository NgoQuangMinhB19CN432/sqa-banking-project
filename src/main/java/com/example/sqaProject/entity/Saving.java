/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sqaProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 *
 * @author Minh ngo
 */
@Data
@Entity
@Table(name = "Saving")
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int savingId;
    
    @Column(name="toDate")
    private String toDate;
    
    @Column(name="originalMoney")
    private int originalMoney;
    
    @Column(name="interestRate")
    private float interestRate;
    
    @Column(name="kindOfProfit")
    private String kindOfProfit;
    
    @ManyToOne 
    @JoinColumn(name = "bankAccountNumber")
    private BankAccount bankAccountNumber;
}
