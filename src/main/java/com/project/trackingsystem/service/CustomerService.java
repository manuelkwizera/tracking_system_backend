package com.project.trackingsystem.service;

import com.project.trackingsystem.entity.Customer;
import com.project.trackingsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
    public Customer findCustomerById(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("customer not found"));
        return customer;
    }
    public void createCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void deleteCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("customer not found"));
        customerRepository.deleteById(customer.getId());
    }
}
