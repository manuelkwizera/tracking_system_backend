package com.project.trackingsystem.controller;

import com.project.trackingsystem.entity.Customer;
import com.project.trackingsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public String findAllCustomers(Model model){
        List<Customer> customers = customerService.findAllCustomers();
        model.addAttribute("page_title", "Customers");
        model.addAttribute("customers", customers);
        return "customer/index";
    }

    @GetMapping("/add-customer")
    public String addCastomer(Customer customer, Model model){
        model.addAttribute("page_title", "Add Customer");
        model.addAttribute("form_name", "Customer Form");
        return "customer/add";
    }
    @PostMapping("/save-customer")
    public String saveCustomer(Customer customer, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/add-customer";
        }

        customerService.createCustomer(customer);
        model.addAttribute("customers", customerService.findAllCustomers());
        return "redirect:/customers";
    }

    @GetMapping("/remove-customer/{id}")
    public String deleteCustomer(@PathVariable Long id, Model model){
        customerService.deleteCustomer(id);
        model.addAttribute("customers", customerService.findAllCustomers());
        return "redirect:/customers";
    }

    @GetMapping("/edit-customer/{id}")
    public String editCustomer(@PathVariable Long id, Model model){
        model.addAttribute("page_title", "Edit Customer");
        model.addAttribute("customer", customerService.findCustomerById(id));
        return "customer/edit";
    }
    @PostMapping("/update-customer/{id}")
    public String updateCustomer(@PathVariable Long id, Customer customer, BindingResult result, Model model){
        if(result.hasErrors()){
            return "redirect:/edit-customer";
        }
        customerService.updateCustomer(customer);
        model.addAttribute("customers", customerService.findAllCustomers());
        return "redirect:/customers";
    }
}
