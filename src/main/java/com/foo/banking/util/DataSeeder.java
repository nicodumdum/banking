package com.foo.banking.util;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.foo.banking.entity.BankAccount;
import com.foo.banking.entity.Customer;
import com.foo.banking.repository.BankAccountRepository;
import com.foo.banking.repository.CustomerRepository;
import com.foo.banking.repository.TransactionRepository;

@Profile("dataSeeder")
@Component
public class DataSeeder 
{

	@PostConstruct
	public void run() 
	{
	}
}

	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransactionRepository transcationRepository;
	
	@PostConstruct
	public void run() 
	{
		Customer customer1 = new Customer();
		customer1.setFirstName("Mike");
		customer1.setLastName("Litoris");
		customer1.setMiddleName(":");
		customer1.setBirthDate(new Date(1990,12,25));
		customer1.setGender("Male");
		customer1 = customerRepository.save(customer1);
		
		Customer customer2 = new Customer();
		customer2.setFirstName("Gina");
		customer2.setLastName("Cole");
		customer2.setMiddleName(":");
		customer2.setBirthDate( new Date(1990,12,25));
		customer2.setGender("Female");
		customer2 = customerRepository.save(customer2);

		Customer customer3 = new Customer();
		customer3.setFirstName("Gina");
		customer3.setLastName("Hasa");
		customer3.setMiddleName(":");
		customer3.setBirthDate(new Date(1990,12,25));
		customer3.setGender("Male");
		customer3 = customerRepository.save(customer3);
		
		BankAccount bankAccount1 = new BankAccount();
		bankAccount1.setAccountNumber("1111-1111-1111-1111");
		bankAccount1.setActive(true);
		bankAccount1.setCreatedAt(new Date(1990,12,25));
		bankAccount1.setCurrentBalance((double) 10000);
		bankAccount1.setCurrentBalance((double) 10000);
		bankAccount1.setCustomer(customer1);
		bankAccount1 = bankAccountRepository.save(bankAccount1);
		
		BankAccount bankAccount2 = new BankAccount();
		bankAccount2.setAccountNumber("2222-2222-2222-2222");
		bankAccount2.setActive(true);
		bankAccount2.setCreatedAt(new Date(1990,12,25));
		bankAccount2.setCurrentBalance((double) 10000);
		bankAccount2.setCurrentBalance((double) 10000);
		bankAccount2.setCustomer(customer2);
		bankAccount2 = bankAccountRepository.save(bankAccount2);
		
		BankAccount bankAccount3 = new BankAccount();
		bankAccount3.setAccountNumber("3333-3333-3333-3333");
		bankAccount3.setActive(true);
		bankAccount3.setCreatedAt(new Date(1990,12,25));
		bankAccount3.setCurrentBalance((double) 10000);
		bankAccount3.setCurrentBalance((double) 10000);
		bankAccount3.setCustomer(customer3);
		bankAccount3 = bankAccountRepository.save(bankAccount3);
	}
}	

