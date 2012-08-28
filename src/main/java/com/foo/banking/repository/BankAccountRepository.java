package com.foo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foo.banking.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long>
{
	List<BankAccount> findById(Long id);
}
