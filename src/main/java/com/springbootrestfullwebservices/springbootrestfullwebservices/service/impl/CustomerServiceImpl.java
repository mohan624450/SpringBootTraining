package com.springbootrestfullwebservices.springbootrestfullwebservices.service.impl;

import com.springbootrestfullwebservices.springbootrestfullwebservices.entity.Customer;
import com.springbootrestfullwebservices.springbootrestfullwebservices.repository.CustomerRepository;
import com.springbootrestfullwebservices.springbootrestfullwebservices.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        customer.setId(uuid);
        return customerRepository.save(customer);
    }
}
