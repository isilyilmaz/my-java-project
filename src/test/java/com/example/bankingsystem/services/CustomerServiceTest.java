package com.example.bankingsystem.services;

import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.models.Customer;
import com.example.bankingsystem.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        // Mocking the CustomerRepository using Mockito
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerService(customerRepository);
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer(0, "John ","Doe", new Date(99,10,5), Gender.CODE_MALE, "john.doe@example.com", null, null,null);

        // Execute the service method
        customerService.addCustomer(customer);

        // Verify that the repository's add method was called with the correct customer
        verify(customerRepository, times(1)).add(customer);
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer(1, "Jane","Doe", new Date(96,10,15), Gender.CODE_FEMALE, "jane.doe@example.com", null,null, null);

        // Mock the repository method
        when(customerRepository.getById(1)).thenReturn(Optional.of(customer));

        // Execute the service method
        Optional<Customer> retrievedCustomer = customerService.getCustomerById(1);

        // Verify the results
        assertTrue(retrievedCustomer.isPresent());
        assertEquals("Jane Doe", retrievedCustomer.get().getName());
    }

    @Test
    void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(0, "John ","Doe", new Date(99,10,5), Gender.CODE_MALE, "john.doe@example.com", null, null,null));
        customers.add(new Customer(1, "Jane","Doe", new Date(96,10,15), Gender.CODE_FEMALE, "jane.doe@example.com", null,null, null));

        // Mock the repository method
        when(customerRepository.getAll()).thenReturn(customers);

        // Execute the service method
        List<Customer> result = customerService.getAllCustomers();

        // Verify the results
        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Doe", result.get(1).getName());
    }

    @Test
    void testUpdateCustomer() {
        Customer customer = new Customer(1, "John ","Doe", new Date(99,10,5), Gender.CODE_MALE, "john.doe@example.com", null, null,null);

        // Execute the service method
        customerService.updateCustomer(customer);

        // Verify that the repository's update method was called with the correct customer
        verify(customerRepository, times(1)).update(customer);
    }

    @Test
    void testDeleteCustomer() {
        int customerId = 1;

        // Execute the service method
        customerService.deleteCustomer(customerId);

        // Verify that the repository's delete method was called with the correct ID
        verify(customerRepository, times(1)).delete(customerId);
    }
}
