package com.demo.oauthdemo.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.oauthdemo.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer findByAccountNumber(String string);

}
