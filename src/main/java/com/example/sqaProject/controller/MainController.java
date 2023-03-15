/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sqaProject.controller;

import com.example.sqaProject.entity.Customer;
import com.example.sqaProject.entity.BankAccount;
import com.example.sqaProject.repository.BankAccountRepo;
import com.example.sqaProject.repository.CreditRepo;
import com.example.sqaProject.repository.CustomerRepo;
import com.example.sqaProject.repository.SavingRepo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 *
 * @author Minh ngo
 */
@Controller
public class MainController {
    @Autowired
    BankAccountRepo BankAccountRepo;
    @Autowired
    CustomerRepo CustomerRepo;
    @Autowired
    SavingRepo SavingRepo;
    @Autowired
    CreditRepo CreditRepo;
    
    @RequestMapping(value="/login")
    public String Login() {
        return "login";
    }
    
    @RequestMapping(value="/menu")
    public String menu(Model model) {
        List <Customer> c = CustomerRepo.findAll(); 
        model.addAttribute("customers", c);
        return "menu-admin";
    }
    
    @RequestMapping(value="/account")
    public String AccountBanking(@RequestParam("id") String bankAccountNumber, Model model) {
        Optional<BankAccount> a = BankAccountRepo.findById(bankAccountNumber);
        model.addAttribute("account", a);
        return "banking-account-information";
    }
    
    @RequestMapping(value="/user")
    public String Customer(@RequestParam("id") String id, Model model) {
        Optional<Customer> c = CustomerRepo.findById(id);
        model.addAttribute("account", c);
        return "user-information";
    }
}
