package com.example.sqaProject.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.sqaProject.entity.Credit;
import com.example.sqaProject.entity.Saving;
import com.example.sqaProject.service.impl.CreditService;
import com.example.sqaProject.service.impl.SavingService;

@Controller
public class ReportController {
	@Autowired
	private SavingService savingService;
	
	@Autowired
	private CreditService creditService;
	
	@GetMapping("/report-book")
	public String reportPage(Model model) {
		Date datee = new Date();
		String ngay = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime());
		String ngay1 = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime() - 7 * 24 * 60 * 60 * 1000);
		String ngay2 = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime() - 30 * 24 * 60 * 60 * 1000);
		List<Saving> list = savingService.findAllByDate(ngay);
		List<Saving> list1 = savingService.getBillByDate(ngay1, ngay);
		List<Saving> list2 = savingService.getBillByDate(ngay2, ngay);
		model.addAttribute("list1", list);
		model.addAttribute("list2", list2);
		return "reportPage";
	}
	@GetMapping("/report-borrow")
	public String reportBorrowPage(Model model) {
		Date datee = new Date();
		String ngay = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime());
//		String ngay1 = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime() - 7 * 24 * 60 * 60 * 1000);
//		String ngay2 = new SimpleDateFormat("yyyy/MM/dd").format(datee.getTime() - 30 * 24 * 60 * 60 * 1000);
		List<Credit> list = creditService.findByBorrowDay(ngay);
		List<Credit> list2 = new ArrayList<>();
		model.addAttribute("list1", list);
		model.addAttribute("list2", list2);
		return "reportBorrowPage";
	}
	@GetMapping("/listSaving")
	public String ListSaving(Model model) {
		List<Saving> list = savingService.findAll();
		model.addAttribute("list", list);
		return "ListSaving";
	}
	@GetMapping("/listCredit")
	public String ListCredit(Model model) {
		List<Credit> list = creditService.findAll();
		model.addAttribute("list", list);
		return "ListCredit";
	}
        
        @GetMapping("/report-profit")
	public String reportProfitPage(Model model) {
                List<Credit> list = creditService.findAll();
		model.addAttribute("credits", list);
                return "reportProfit";
	}
}
