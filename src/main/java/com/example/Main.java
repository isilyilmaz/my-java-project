package com.example.bankingsystem;

import com.example.bankingsystem.enums.CardType;
import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.enums.TransactionCode;
import com.example.bankingsystem.models.Customer;
import com.example.bankingsystem.repositories.CustomerRepository;
import com.example.bankingsystem.repositories.TransactionRepository;
import com.example.bankingsystem.services.BankingService;
import com.example.bankingsystem.services.CustomerService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        BankingService service = new BankingService();

       /* // Add a customer
        service.addCustomer("Alice", "Smith", new Date(800000000000L), Gender.CODE_FEMALE, "alice.smith@example.com", "456 Maple St.");

        // Add a card
        service.addCard(1, "4111-2222-3333-4444", CardType.VISA, 10000.0);

        // Add a transaction
        service.addTransaction("5111-2222-3333-4444", TransactionCode.CODE_BUY, 500.0, new Date());
*/
        // Other operations...

        CustomerRepository customerRepository = new CustomerRepository();
        CustomerService customerService = new CustomerService(customerRepository);

        // Create and add a new customer
        Customer customer = new Customer(1, "John","Doe", new Date(99,10,5), Gender.CODE_MALE,"john.doe@example.com" ,null,null, null);
        customerService.addCustomer(customer);

        // Retrieve and display all customers
        List<Customer> customers = customerService.getAllCustomers();
        customers.forEach(c -> System.out.println("Customer: " + c.getName()));

        // Find a customer by ID
        Optional<Customer> retrievedCustomer = customerService.getCustomerById(customers.get(0).getId());
        System.out.println("Retrieved Customer: " + retrievedCustomer.get().getName());

        // Delete the customer
        customerService.deleteCustomer(customers.get(0).getId());
    }
}
