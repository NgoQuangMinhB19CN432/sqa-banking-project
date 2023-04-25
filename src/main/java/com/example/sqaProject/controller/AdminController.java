package com.example.sqaProject.controller;

import com.example.sqaProject.entity.Admin;
import com.example.sqaProject.service.impl.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class AdminController {
	@Autowired
	private AdminService adminService;
	@GetMapping("/")
	public String index(Model model) {
		Admin admin= new Admin();
		model.addAttribute("admin", admin);
		return "login";
	}
	@PostMapping("/login")
	public String login(Admin admin,Model model, HttpSession session) {
		String user=admin.getUsername();
		session.setAttribute("name", user);
		if(adminService.checkLogin(admin.getUsername(), admin.getPassword())) {
			return "AdminPage";
		}
		else if(admin.getUsername().equals("") || admin.getPassword().equals("")) {
			model.addAttribute("admin", admin);
			model.addAttribute("message","please enter full username and password!!!");
			return "login";
		}
		else {
			model.addAttribute("admin", admin);
			model.addAttribute("message","username/password invalid!!!");
			return "login";
		}
	}
	
}
