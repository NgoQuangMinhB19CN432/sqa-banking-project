/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.sqaProject.service;

import com.example.sqaProject.entity.Admin;
import java.util.List;

/**
 *
 * @author Minh ngo
 */
public interface IAdminService {
    	List<Admin> findAll();
	boolean checkLogin(String user,String pass);
}
