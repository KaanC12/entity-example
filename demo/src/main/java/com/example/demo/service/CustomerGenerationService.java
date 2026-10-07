package com.example.demo.service;

import com.example.demo.repo.CustomerRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import com.example.demo.dto.NewCustomer;
import com.example.demo.entity.Customer;

@Service 
@AllArgsConstructor 
public class CustomerGenerationService {
    private final CustomerRepository customerRepository;

    public void saveCustomer(NewCustomer newCustomer) {
        Customer customer = new Customer();
        customer.setName(newCustomer.getName());
        customer.setCustomerStreet(newCustomer.getCustomerStreet());
        customer.setCustomerCity(newCustomer.getCustomerCity());
        customerRepository.save(customer);
    }
}