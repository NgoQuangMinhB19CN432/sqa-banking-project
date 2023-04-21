package com.example.sqaProject.controller;

import com.example.sqaProject.entity.Credit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sqaProject.entity.CreditTerm;
import com.example.sqaProject.entity.Role;
import com.example.sqaProject.entity.Saving;
import com.example.sqaProject.entity.SavingTerm;
import com.example.sqaProject.service.impl.BankAccountService;
import com.example.sqaProject.service.impl.CreditService;
import com.example.sqaProject.service.impl.CreditTermService;
import com.example.sqaProject.service.impl.RoleService;
import com.example.sqaProject.service.impl.SavingService;
import com.example.sqaProject.service.impl.SavingTermService;

import jakarta.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class ConfigController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private SavingTermService savingTermService;
	@Autowired 
	private CreditTermService creditTermService;
        
        @Autowired 
        private BankAccountService bankAccountService;
        @Autowired 
        private CreditService creditService;
        @Autowired 
        private SavingService SavingService;
	
	@GetMapping("/saving-config")
	public String savingConfig(HttpSession session, Model model) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("savingTerms", savingTermService.findAll());
		return "configPage";
	}
	
	// crud ROLE
	
	@GetMapping("/editRole{code}")
	public String editRole(@PathVariable("code") int code,Model model,HttpSession session) {
		Role role= roleService.findByCode(code);
		model.addAttribute("role",role);
		return "editRole";
	}
	@GetMapping("/createRole")
	public String createRole(Model model) {
		model.addAttribute("role", new Role());
		return "createRole";
	}
	@PostMapping("/saveRole")
	public String createRoleT(Role role,BindingResult result,Model model) {
		if(result.hasErrors()) {
    		model.addAttribute("message","please reenter to data");
    		model.addAttribute("role",role);
    		return "createRole";
    	}
		if(role.getStatus().equals("hoạt động")==false && role.getStatus().equals("bị khóa")==false) {
			model.addAttribute("message","please enter data true!!!");
			model.addAttribute("role",role);
			return "createRole";
		}
		roleService.save(role);
		return "redirect:/saving-config";
	}
	@PostMapping("/roleUpdate")
	public String roleUpdateT(@RequestParam(name="code") int code,Role role,BindingResult result, Model model,HttpSession session) {
		if(result.hasErrors()) {
    		model.addAttribute("message","please reenter to data");
    		model.addAttribute("role",role);
    		return "editRole";
    	}
		Role rol= new Role();
		rol.setCode(code);
		rol.setContent(role.getContent());
		rol.setName(role.getName());
		rol.setStatus(role.getStatus());
		if(rol.getStatus().equals("hoạt động")==false && rol.getStatus().equals("bị khóa")==false) {
			model.addAttribute("message","please enter data true!!!");
			model.addAttribute("role",role);
			return "editRole";
		}
		roleService.delete(role);
		roleService.save(rol);
		return "redirect:/saving-config";
	}
	@GetMapping("/deleteRole{code}")
	public String deleteRole(@PathVariable("code") int code,Model model, HttpSession session) {
		Role role= roleService.findByCode(code);
		roleService.delete(role);
		return "redirect:/saving-config";
	}
	
	//CRUD SAVING
	
	@GetMapping("/editSavingTerm{code}")
	public String editSaving(@PathVariable("code") int code,Model model,HttpSession session) {
		SavingTerm saving= savingTermService.findBySavingId(code);
		model.addAttribute("saving",saving);
		return "editSavingTerm";
	}
	@PostMapping("/savingUpdate")
	public String editSAvingTerm(SavingTerm savingTerm,BindingResult result, Model model,HttpSession session) {
//		try {
		if(result.hasErrors()) {
    		model.addAttribute("message","please re enter to data");
    		model.addAttribute("saving", savingTerm);
    		return "editSavingTerm";
    	}
			SavingTerm sav= new SavingTerm();
			sav.setSavingId(savingTerm.getSavingId());
			sav.setInterestRate(savingTerm.getInterestRate());
			sav.setNumberOfMonth(savingTerm.getNumberOfMonth());
			sav.setStatus(savingTerm.getStatus());
			if(sav.getInterestRate()==0.0 || sav.getNumberOfMonth()==0 || (sav.getStatus().equals("hoạt động")==false && sav.getStatus().equals("bị khóa")==false)) {
				model.addAttribute("message","please enter data true!!!");
				model.addAttribute("saving", savingTerm);
				return "editSavingTerm";
			}
			
			savingTermService.delete(savingTerm);
			savingTermService.save(sav);
			return "redirect:/saving-config";
//		}
//		catch(NumberFormatException e) {
//			model.addAttribute("message","username/password invalid!!!");
//			return "editSavingTerm";
//		}
	}
	@GetMapping("/deleteSavingTerm{code}")
	public String deleteSaving(@PathVariable("code") int code,Model model,HttpSession session) {
		SavingTerm saving= savingTermService.findBySavingId(code);
	    savingTermService.delete(saving);
		return "redirect:/saving-config";
	}
	@GetMapping("/createSavingTerm")
	public String createSavingT(Model model) {
		model.addAttribute("saving", new SavingTerm());
		return "createSavingTerm";
	}
	@PostMapping("/savingSave")
	public String savingUpdate(SavingTerm savingTerm,BindingResult result,Model model) {
		if(result.hasErrors()) {
    		model.addAttribute("message","please re enter to data");
    		model.addAttribute("saving", savingTerm);
    		return "editSavingTerm";
    	}
		if(savingTerm.getInterestRate()==0.0 || savingTerm.getNumberOfMonth()==0 || (savingTerm.getStatus().equals("hoạt động")==false && savingTerm.getStatus().equals("bị khóa")==false)) {
			model.addAttribute("message","please enter data true!!!");
			model.addAttribute("saving", savingTerm);
			return "editSavingTerm";
		}
		savingTermService.save(savingTerm);
		return "redirect:/saving-config";
	}
	@GetMapping("/credit-config")
	public String creditConfig(HttpSession session, Model model) {
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("creditTerms", creditTermService.findAll());
		return "configCreditPage";
	}
	
//	crud CreditTerm
	@GetMapping("/editCreditTerm{code}")
	public String editCredit(@PathVariable("code") int code,Model model,HttpSession session) {
		CreditTerm saving= creditTermService.findByCreditId(code);
		model.addAttribute("creditTerm",saving);
		return "editCreditTerm";
	}
	@PostMapping("/creditTermUpdate")
	public String editCreditTerm(CreditTerm creditTerm,BindingResult result, Model model,HttpSession session) {
		if(result.hasErrors()) {
    		model.addAttribute("message","please re enter to data");
    		model.addAttribute("creditTerm",creditTerm );
    		return "editCreditTerm";
    	}
		CreditTerm cre= new CreditTerm();
		cre.setCreditId(creditTerm.getCreditId());
		cre.setInterestRate(creditTerm.getInterestRate());
		cre.setNumberOfMonth(creditTerm.getNumberOfMonth());
		cre.setStatus(creditTerm.getStatus());
		
		if(cre.getInterestRate()==0.0 || cre.getNumberOfMonth()==0 || (cre.getStatus().equals("hoạt động")==false && cre.getStatus().equals("bị khóa")==false)) {
			model.addAttribute("message","please enter data true!!!");
			model.addAttribute("creditTerm", creditTerm);
			return "editCreditTerm";
		}
		creditTermService.deleleById(creditTerm.getCreditId());
		creditTermService.delete(creditTerm);
		
		creditTermService.save(creditTerm);
		
		return "redirect:/credit-config";
	}
	@GetMapping("/deleteCreditTerm{code}")
	public String deleteCredit(@PathVariable("code") int code,Model model,HttpSession session) {
		CreditTerm saving= creditTermService.findByCreditId(code);
	    creditTermService.delete(saving);
		return "redirect:/credit-config";
	}
	@GetMapping("/createCreditTerm")
	public String createCreditT(Model model) {
		model.addAttribute("credit", new SavingTerm());
		return "createCreditTerm";
	}
	@PostMapping("/creditSave")
	public String creditUpdate(CreditTerm creditTerm,BindingResult result,Model model) {
		if(result.hasErrors()) {
    		model.addAttribute("message","please re enter to data");
    		model.addAttribute("creditTerm",creditTerm);
    		return "editCreditTerm";
    	}
		if(creditTerm.getInterestRate()==0.0 || creditTerm.getNumberOfMonth()==0 || (creditTerm.getStatus().equals("hoạt động")==false && creditTerm.getStatus().equals("bị khóa")==false)) {
			model.addAttribute("message","please enter data true!!!");
			model.addAttribute("creditTerm", creditTerm);
			return "editSavingTerm";
		}
		creditTermService .save(creditTerm);
		return "redirect:/credit-config";
	}
        
        
        
        @GetMapping("/SavingBooks")
        public String SavingBooks(Saving Saving,Model model) {
            model.addAttribute("savingbooks", SavingService.findAll());
            return "savingBooks";
        }
        @GetMapping("/Credits")
        public String Credits(Credit Credit,Model model) {
            List<Credit> c = creditService.findAll();
            for(Credit credit : c) {
                String dateString = credit.getPayDay();
                LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate currentDate = LocalDate.now();
                if (date.compareTo(currentDate) <= 0) {
                    credit.setStatus(1);
                } else credit.setStatus(0);
            }
            creditService.saveAll(c);
            model.addAttribute("credits", c);
            return "Credits";
        }
        
        @GetMapping("/ProfitReport")
        public String CreditReport(Credit Credit,Model model) {
            List<Credit> c = creditService.findAll();
            for(Credit obj : c) {
                obj.setFormattedMoney(new DecimalFormat("#,###.00").format(obj.getMoney()));
            }
            creditService.saveAll(c);
            model.addAttribute("credits", c);
            return "ProfitReport";
        }   
}
