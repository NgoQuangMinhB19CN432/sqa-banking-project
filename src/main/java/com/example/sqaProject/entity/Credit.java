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
@Table(name = "Credit")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditId;
    
    @Column(name="money")
    private int money;
    
    @Column(name="borrowDay")
    private String borrowDay;
    
    @Column(name="payDay")
    private String payDay;
    
    @Column(name="interestRate")
    private float interestRate;
    
    @Column(name="mortgage")
    private String mortgage;
    
    @ManyToOne 
    @JoinColumn(name = "bankAccountNumber")
    private BankAccount bankAccountNumber;
}
