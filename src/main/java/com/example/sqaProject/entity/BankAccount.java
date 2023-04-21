package com.example.sqaProject.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.text.DecimalFormat;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @Column(name="bank_account_number")
    private String bankAccountNumber;
    
    @Column(name="money")
    private float money;
    private String formattedMoney;
    
    @Column(name="credit_score")
    private float creditScore;
    
    @Column(name="fullname")
    private String fullname ;
    @Column(name="age")
    private int age;
    @Column(name="address")
    private String address;
    @Column(name="phonenumber")
    private String phonenumber;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @OneToMany(mappedBy = "bankAccount")
    List <Credit> credits;
    
    @OneToMany(mappedBy = "bankAccount")
    List <Saving> savings;
}
