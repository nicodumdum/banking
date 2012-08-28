package com.foo.banking.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.foo.banking.entity.Transaction;
import com.foo.banking.repository.TransactionRepository;

@Component("TransactionValidator")
public class TransactionValidator implements Validator
{
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Transaction.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		Transaction transaction = (Transaction)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "account", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "transactionDate", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "transactionType", null, "This should not be empty!");
		// Check for uniqueness
		if(transactionRepository.findById(transaction.getId()).size() > 0 && transaction.isNew()) 
		{
			errors.rejectValue("Id", null, "Id already used!");
		}
	}
}
