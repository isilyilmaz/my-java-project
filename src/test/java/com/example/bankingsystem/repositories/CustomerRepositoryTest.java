package com.example.bankingsystem.repositories;

import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepository();
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer(1, "Alice", "Smith", new Date(116,4,29), Gender.CODE_FEMALE, "alice@example.com", "456 Maple St.",null,null);
        customerRepository.add(customer);
        assertEquals(1, customerRepository.getAll().size());
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer(1, "Alice", "Smith", new Date(115,3,15), Gender.CODE_FEMALE, "alice@example.com", "456 Maple St.",null,null);
        customerRepository.add(customer);
        Optional<Customer> retrievedCustomer = customerRepository.getById(1);
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("Alice", retrievedCustomer.get().getName());
    }

    @Test
    void testDeleteCustomer() {
        Customer customer = new Customer(1, "Alice", "Smith", new Date(94,6,9), Gender.CODE_FEMALE, "alice@example.com", "456 Maple St.",null,null);
        customerRepository.add(customer);
        customerRepository.delete(1);
        assertEquals(0, customerRepository.getAll().size());
    }
}
