/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.example.sqaProject.service.impl;

import com.example.sqaProject.entity.Admin;
import com.example.sqaProject.repository.AdminRepository;
import com.example.sqaProject.service.IAdminService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Minh ngo
 */
@Service
public class AdminService implements IAdminService {
	@Autowired
	private AdminRepository adminRepository;
	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public boolean checkLogin(String user, String pass) {
		// TODO Auto-generated method stub
		List<Admin> list = adminRepository.findAll();
		for(Admin ad:list) {
			if(ad.getUsername().equals(user) && ad.getPassword().equals(pass)) {
				return true;
			}
		}
		return false;
	}

}
