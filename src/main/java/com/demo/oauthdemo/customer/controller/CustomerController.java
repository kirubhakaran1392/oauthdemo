package com.demo.oauthdemo.customer.controller;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.demo.oauthdemo.customer.domain.Customer;
import com.demo.oauthdemo.customer.repository.CustomerRepository;

@RestController
public class CustomerController {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/")
	private Customer retriveCustomerByHeaders(@RequestHeader Map<String, String> headers) {
		
		headers.forEach((key, value) -> {
			logger.info(String.format("Header '%s' = %s", key, value));
	    });
		//8888888
		System.out.println(headers.get("x-accountnumber"));
		//Optional<String> accountNumber = Optional.ofNullable(headers.get("x-accountnumber"));
		//String accountNumber = .
		return customerRepository.findByAccountNumber(headers.get("x-accountnumber"));
	}
	
	@GetMapping("/{customerNumber}")
	private Optional<Customer> retriveCustomerById(@PathVariable long customerNumber) {
		return customerRepository.findById(customerNumber);
	}
	
	@PostMapping("/")
	private Customer createCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@DeleteMapping("/{customerNumber}")
	private void removeCustomerById(@PathVariable long customerNumber) {
		Optional<Customer> customer = customerRepository.findById(customerNumber);
		if(customer.isPresent()) {
			System.out.println("Removing customer >> "+ customerNumber);
			System.out.println(customer.get().toString());
			customerRepository.delete(customer.get());
		}
		
	}
}
