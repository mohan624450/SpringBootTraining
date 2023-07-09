package com.springbootrestfullwebservices.springbootrestfullwebservices.repository;

import com.springbootrestfullwebservices.springbootrestfullwebservices.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
