/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sqaProject.repository;

import com.example.sqaProject.entity.Saving;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Minh ngo
 */
public interface SavingRepo extends JpaRepository<Saving, String>{
    
}
