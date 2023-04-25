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
		String ngay = new SimpleDateFormat("yyyy-MM-dd").format(datee.getTime());
                List<Saving> lAll = savingService.findAll();
                List<Saving> lMonth = new ArrayList<>();
                for(Saving sv: lAll) {
                    if(sv.getToDate().substring(0, sv.getToDate().length()-3).equalsIgnoreCase(ngay.substring(0,ngay.length()-3))) {
                        lMonth.add(sv);
                    }
                }
		List<Saving> list = savingService.findByToDate(ngay);
		model.addAttribute("list1", list);
		model.addAttribute("list2", lMonth);
		return "reportPage";
	}
	@GetMapping("/report-borrow")
	public String reportBorrowPage(Model model) {
		Date datee = new Date();
		String ngay = new SimpleDateFormat("yyyy-MM-dd").format(datee.getTime());
		List<Credit> lAll = creditService.findAll();
                List<Credit> lMonth = new ArrayList<>();
                for(Credit sv: lAll) {
                    if(sv.getBorrowDay().substring(0, sv.getBorrowDay().length()-3).equalsIgnoreCase(ngay.substring(0,ngay.length()-3))) {
                        lMonth.add(sv);
                    }
                }
		List<Credit> list = creditService.findByBorrowDay(ngay);
		model.addAttribute("list1", list);
		model.addAttribute("list2", lMonth);
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
