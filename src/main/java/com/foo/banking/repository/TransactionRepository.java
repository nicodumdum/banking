package com.foo.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foo.banking.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> 
{

}
