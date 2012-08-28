package com.foo.banking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.foo.banking.entity.BankAccount;
import com.foo.banking.repository.BankAccountRepository;
import com.foo.banking.util.BankAccountValidator;
@Controller
@RequestMapping("/admin/bankaccounts")
public class BankAccountController {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private BankAccountValidator bankAccountValidator;
	
	@RequestMapping(value={"", "/", "/index"})
	public String index(Model uiModel) {
		
		List<BankAccount> bankaccounts = bankAccountRepository.findAll();
		uiModel.addAttribute("bankaccounts", bankaccounts);
		
		return "admin/bankaccounts/index";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model uiModel) {
		
		BankAccount bankAccount = bankAccountRepository.findOne(id);
		uiModel.addAttribute("bankAccount", bankAccount);
		
		return "admin/bankaccounts/show";
	}
	
	@RequestMapping(value="/create")
	public String create(Model uiModel) {
		
		uiModel.addAttribute("bankAccount", new BankAccount());
		
		return "admin/bankaccounts/create";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(BankAccount bankAccount, BindingResult result, HttpServletRequest request, Model uiModel)
	{
		bankAccountValidator.validate(bankAccount, result);
		if(result.hasErrors()) {
			uiModel.addAttribute("errors", result.getAllErrors());
			uiModel.addAttribute("bankAccount", bankAccount);
			
			return "admin/bankaccounts/create";
		}
		
		bankAccount = bankAccountRepository.save(bankAccount);
		
		return  "redirect:/admin/bankaccounts";
	}
}
