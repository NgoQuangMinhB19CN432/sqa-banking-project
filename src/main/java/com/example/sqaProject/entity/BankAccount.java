/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sqaProject.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author Minh ngo
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BankAccount")
public class BankAccount {
    @Id
    private String bankAccountNumber;
    
    @Column(name="money")
    private int money;
    
    @JoinColumn(name="creditScore")
    private float creditScore;
    
    @OneToMany(mappedBy = "bankAccountNumber", cascade = CascadeType.ALL)
    List <Credit> credits;
    
    @OneToMany(mappedBy = "bankAccountNumber", cascade = CascadeType.ALL)
    List <Saving> savings;
}
