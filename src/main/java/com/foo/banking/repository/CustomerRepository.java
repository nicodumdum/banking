package com.foo.banking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foo.banking.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
	List<Customer> findById(Long id);
}