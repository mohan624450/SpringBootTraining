package com.springbootrestfullwebservices.springbootrestfullwebservices.controller;

import com.springbootrestfullwebservices.springbootrestfullwebservices.entity.Customer;
import com.springbootrestfullwebservices.springbootrestfullwebservices.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomerController {

    private CustomerService customerService;


    @PostMapping("create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        System.out.println(customer.toString());
        Customer customer1 = customerService.createCustomer(customer);
        return new ResponseEntity<>(customer1, HttpStatus.CREATED);
    }
}
