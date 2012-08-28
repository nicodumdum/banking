package com.foo.banking.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.foo.banking.entity.Customer;
import com.foo.banking.repository.CustomerRepository;

@Component("CustomerValidator")
public class CustomerValidator implements Validator
{
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//Typecast
		Customer customer = (Customer)target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middleName", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", null, "This should not be empty!");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "gender", null, "This should not be empty!");
		// Check for uniqueness
		if(customerRepository.findById(customer.getId()).size() > 0 && customer.isNew()) 
		{
			errors.rejectValue("Id", null, "Id already used!");
		}
	}
}
