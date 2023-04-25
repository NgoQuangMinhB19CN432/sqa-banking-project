package com.example.sqaProject.controller;

import com.example.sqaProject.entity.CreditTerm;
import com.example.sqaProject.entity.Role;
import com.example.sqaProject.entity.SavingTerm;
import com.example.sqaProject.service.impl.CreditTermService;
import com.example.sqaProject.service.impl.RoleService;
import com.example.sqaProject.service.impl.SavingTermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import jakarta.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ConfigController {
	@Autowired
	private RoleService roleService;
	@Autowired
	private SavingTermService savingTermService;
	@Autowired 
	private CreditTermService creditTermService;
	
	
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
	@GetMapping("/createRole1")
	public String createRole1(Model model) {
		model.addAttribute("role", new Role());
		return "createCreditRole";
	}
	@PostMapping("/saveRole")
	public String createRoleT(Role role,BindingResult result,HttpSession session,Model model) {
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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        role.setCreatedDate(strDate);
        role.setCreatedBy((String)session.getAttribute("name"));
		roleService.save(role);
		return "redirect:/saving-config";
	}
	@PostMapping("/saveRoleCredit")
	public String createRoleTC(Role role,BindingResult result,HttpSession session,Model model) {
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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        role.setCreatedDate(strDate);
        role.setCreatedBy((String)session.getAttribute("name"));
		roleService.save(role);
		return "redirect:/credit-config";
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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        rol.setModifiedDate(strDate);
        rol.setModifiedBy((String)session.getAttribute("name"));
		roleService.update(rol.getCode(), rol.getName(), rol.getContent(), rol.getStatus(),rol.getModifiedBy(),rol.getModifiedDate(), rol.getCode());
		return "redirect:/saving-config";
	}
	@GetMapping("/deleteRole{code}")
	public String deleteRole(@PathVariable("code") int code,Model model, HttpSession session) {
		Role role= roleService.findByCode(code);
		model.addAttribute("message1","Xóa thành công!!!");
		roleService.delete(role);
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("savingTerms", savingTermService.findAll());
		return "configPage";
	}
	@GetMapping("/deleteRole1{code}")
	public String deleteRole1(@PathVariable("code") int code,Model model, HttpSession session) {
		Role role= roleService.findByCode(code);
		model.addAttribute("message1","Xóa thành công!!!");
		roleService.delete(role);
		model.addAttribute("name", session.getAttribute("name"));
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("creditTerms", creditTermService.findAll());
		return "configCreditPage";
	}
	
	//CRUD SAVING
	
	@GetMapping("/editSavingTerm{code}")
	public String editSaving(@PathVariable("code") int code,Model model,HttpSession session) {
		SavingTerm saving= savingTermService.findBySavingId(code);
		model.addAttribute("saving",saving);
		return "editSavingTerm";
	}
	@PostMapping("/savingUpdate")
	public String editSAvingTerm(SavingTerm saving,BindingResult result, Model model,HttpSession session) {
//		try {
		if(result.hasErrors()) {
    		model.addAttribute("message","please re enter to data");
    		model.addAttribute("saving", saving);
    		return "editSavingTerm";
    	}
			SavingTerm sav= new SavingTerm();
			sav.setSavingId(saving.getSavingId());
			sav.setInterestRate(saving.getInterestRate());
			sav.setNumberOfMonth(saving.getNumberOfMonth());
			sav.setStatus(saving.getStatus());
			if(sav.getInterestRate()==0.0 || sav.getNumberOfMonth()==0 || (sav.getStatus().equals("hoạt động")==false && sav.getStatus().equals("bị khóa")==false)) {
				model.addAttribute("message","please enter data true!!!");
				model.addAttribute("saving", saving);
				return "editSavingTerm";
			}
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	        String strDate = formatter.format(date);
	        sav.setModifiedBy((String) session.getAttribute("name"));
	        sav.setModifiedDate(strDate);
			savingTermService.update(sav.getSavingId(),sav.getInterestRate(),sav.getNumberOfMonth(),sav.getStatus(),sav.getModifiedBy(),sav.getModifiedDate(),sav.getSavingId());
			return "redirect:/saving-config";
	}
	@GetMapping("/deleteSavingTerm{code}")
	public String deleteSaving(@PathVariable("code") int code,Model model,HttpSession session) {
		SavingTerm saving= savingTermService.findBySavingId(code);
		if(savingTermService.checkDeleteSavingTerm(saving)==false) {
			model.addAttribute("message","Không thể xóa lãi xuất này vì còn tồn tại sổ tiết kiệm sử dụng!!!");
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("savingTerms", savingTermService.findAll());
			return "configPage";
		}
		else {
			savingTermService.delete(saving);
			model.addAttribute("message","Xóa thành công!!!");
			model.addAttribute("name", session.getAttribute("name"));
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("savingTerms", savingTermService.findAll());
			return "configPage";
		}
	}
	@GetMapping("/createSavingTerm")
	public String createSavingT(Model model) {
		model.addAttribute("saving", new SavingTerm());
		return "createSavingTerm";
	}
	@PostMapping("/savingSave")
	public String savingUpdate(SavingTerm savingTerm,BindingResult result,HttpSession session,Model model) {
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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        savingTerm.setCreatedBy((String) session.getAttribute("name"));
        savingTerm.setCreatedDate(strDate);
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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        cre.setModifiedBy((String) session.getAttribute("name"));
        cre.setModifiedDate(strDate);
		creditTermService.update(cre.getCreditId(), cre.getInterestRate(), cre.getNumberOfMonth(), cre.getStatus(),cre.getModifiedBy(),cre.getModifiedDate(), cre.getCreditId());
		
		return "redirect:/credit-config";
	}
	@GetMapping("/deleteCreditTerm{code}")
	public String deleteCredit(@PathVariable("code") int code,Model model,HttpSession session) {
		CreditTerm saving= creditTermService.findByCreditId(code);
		if(creditTermService.checkDeleteCreditTerm(saving)==false) {
			model.addAttribute("message","Không thể xóa lãi xuất này vì còn tồn tại sổ vay sử dụng!!!");
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("creditTerms", creditTermService.findAll());
			return "configCreditPage";
		}
		else {
			creditTermService.delete(saving);
			model.addAttribute("message","Xóa thành công!!!");
			model.addAttribute("name", session.getAttribute("name"));
			model.addAttribute("roles", roleService.findAll());
			model.addAttribute("creditTerms", creditTermService.findAll());
			return "configCreditPage";
		}
	}
	@GetMapping("/createCreditTerm")
	public String createCreditT(Model model) {
		model.addAttribute("credit", new SavingTerm());
		return "createCreditTerm";
	}
	@PostMapping("/creditSave")
	public String creditUpdate(CreditTerm creditTerm,BindingResult result,HttpSession session,Model model) {
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
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String strDate = formatter.format(date);
        creditTerm.setCreatedBy((String) session.getAttribute("name"));
        creditTerm.setCreatedDate(strDate);
		creditTermService .save(creditTerm);
		return "redirect:/credit-config";
	}
}
