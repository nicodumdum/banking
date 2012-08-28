package com.foo.banking.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.foo.banking.entity.BankAccount;
import com.foo.banking.repository.BankAccountRepository;

@Component("BankAccountValidator")
public class BankAccountValidator implements Validator
{
	@Autowired
	BankAccountRepository bankAccountRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return BankAccount.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		BankAccount bankaccount = (BankAccount)target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountNumber", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isActive", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customer", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "createdAt", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentBalance", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "availableBalance", null, "This should not be empty!");
		// Check for uniqueness
		if(bankAccountRepository.findById(bankaccount.getId()).size() > 0 && bankaccount.isNew()) 
		{
			errors.rejectValue("Id", null, "Id already used!");
		}
	}
	
}
