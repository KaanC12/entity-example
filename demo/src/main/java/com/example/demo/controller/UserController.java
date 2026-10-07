package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.NewCustomer;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerGenerationService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor 
public class UserController {

    private final CustomerGenerationService customerGenerationService;

    @PostMapping("/save")
    public String postMethodName(@RequestBody Customer customer) {
        NewCustomer newCustomer = new NewCustomer();
        newCustomer.setName(customer.getName());
        newCustomer.setCustomerStreet(customer.getCustomerStreet());
        newCustomer.setCustomerCity(customer.getCustomerCity());
        customerGenerationService.saveCustomer(newCustomer);
        return "Customer created successfully!";
    }
    
}