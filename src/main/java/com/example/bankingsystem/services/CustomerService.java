package com.example.bankingsystem.services;

import com.example.bankingsystem.models.Customer;
import com.example.bankingsystem.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        customerRepository.add(customer);
    }

    public Optional<Customer> getCustomerById(int id) {
        return customerRepository.getById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

    public void updateCustomer(Customer customer) {
        customerRepository.update(customer);
    }

    public void deleteCustomer(int id) {
        customerRepository.delete(id);
    }
}
