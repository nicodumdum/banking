package com.foo.banking.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="bank_transaction")
public class Transaction 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private BankAccount account;
	
	@Column(name="transaction_date")
	private Date transactionDate;
	
	@Column(name="amount")
	private Double amount;
	
	/*
	 * Possible values:
	 * - WITHDRAW
	 * - DEPOSIT
	 */
	@Column(name="transaction_type")
	private String transactionType;
	
	public Transaction()
	{
		transactionDate = new Date();
		amount = 0.00;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BankAccount getAccount() {
		return account;
	}

	public void setAccount(BankAccount account) {
		this.account = account;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
}
