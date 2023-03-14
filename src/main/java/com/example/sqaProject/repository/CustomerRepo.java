/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sqaProject.repository;

import com.example.sqaProject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Minh ngo
 */
public interface CustomerRepo extends JpaRepository<Customer, String>{
    
}
