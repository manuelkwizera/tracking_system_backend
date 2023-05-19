package com.project.onlinecourierservicesystem.repository;

import com.project.onlinecourierservicesystem.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
