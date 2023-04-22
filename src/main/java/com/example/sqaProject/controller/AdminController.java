package com.example.sqaProject.controller;

import com.example.sqaProject.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import jakarta.servlet.http.HttpSession;

@Controller
public class AdminController {
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
		if(admin.getUsername().equals("admin") && admin.getPassword().equals("123456")) {
			return "AdminPage";
		}
		else {
			model.addAttribute("admin", admin);
			model.addAttribute("message","username/password invalid!!!");
			return "login";
		}
	}
	
}
