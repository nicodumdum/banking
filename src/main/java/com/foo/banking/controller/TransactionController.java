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

import com.foo.banking.entity.Transaction;
import com.foo.banking.repository.TransactionRepository;
import com.foo.banking.util.TransactionValidator;

@Controller
@RequestMapping("/admin/transactions")
public class TransactionController {
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private TransactionValidator transactionValidator;
	@RequestMapping(value={"", "/", "/index"})
	public String index(Model uiModel) {
		
		List<Transaction> transactions = transactionRepository.findAll();
		uiModel.addAttribute("transactions", transactions);
		
		return "admin/transactions/index";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model uiModel) {
		
		Transaction transaction = transactionRepository.findOne(id);
		uiModel.addAttribute("transaction", transaction);
		
		return "admin/transactions/show";
	}
	
	@RequestMapping(value="/create")
	public String create(Model uiModel) {
		
		uiModel.addAttribute("transaction", new Transaction());
		
		return "admin/transactions/create";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Transaction transaction, BindingResult result, HttpServletRequest request, Model uiModel)
	{
		transactionValidator.validate(transaction, result);
		if(result.hasErrors()) {
			uiModel.addAttribute("errors", result.getAllErrors());
			uiModel.addAttribute("transaction", transaction);
			
			return "admin/transactions/create";
		}
		
		transaction = transactionRepository.save(transaction);
		
		return  "redirect:/admin/transactions";
	}
}
