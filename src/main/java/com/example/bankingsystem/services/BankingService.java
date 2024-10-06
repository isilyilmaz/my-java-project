package com.example.bankingsystem.services;

import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.enums.TransactionCode;
import com.example.bankingsystem.models.Card;
import com.example.bankingsystem.models.Customer;
import com.example.bankingsystem.models.Transaction;
import com.example.bankingsystem.repositories.CustomerRepository;
import com.example.bankingsystem.repositories.CardRepository;
import com.example.bankingsystem.repositories.TransactionRepository;
import com.example.bankingsystem.utils.IDGenerator;

import java.util.Date;

public class BankingService {
    private CustomerRepository customerRepository = new CustomerRepository();
    private CardRepository cardRepository = new CardRepository();
    private TransactionRepository transactionRepository = new TransactionRepository();

    // Add Customer
    public void addCustomer(String name, String surname, Date birthDate, Gender gender, String email, String address) {
        Customer customer = new Customer(IDGenerator.generateCustomerId(), name, surname, birthDate, gender, email, address);
        customerRepository.add(customer);
    }

    // Add Card
    public void addCard(int customerId, String cardNo, String cardType, double limit) {
        if (customerRepository.getById(customerId).isPresent()) {
            Card card = new Card(IDGenerator.generateCardId(), customerId, cardNo, cardType, limit);
            cardRepository.add(card);
        }
    }

    // Add Transaction
    public void addTransaction(String cardNo, TransactionCode transactionCode, double amount, Date date) {
        if (TransactionCode.isValidCode(transactionCode.getCode())) {
            Transaction transaction = new Transaction(IDGenerator.generateTransactionId(),cardNo, transactionCode, amount, date);
            transactionRepository.add(transaction);
        }
    }

    // Other service methods...
}
