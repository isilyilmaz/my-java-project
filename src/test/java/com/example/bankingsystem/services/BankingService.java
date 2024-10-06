package com.example.bankingsystem.services;

import com.example.bankingsystem.enums.CardType;
import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.enums.TransactionCode;
import com.example.bankingsystem.models.Customer;
import com.example.bankingsystem.repositories.CustomerRepository;
import com.example.bankingsystem.repositories.CardRepository;
import com.example.bankingsystem.repositories.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class BankingServiceTest {
    private BankingService bankingService;
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        bankingService = new BankingService();
        customerRepository = new CustomerRepository();
    }

    @Test
    void testAddCustomer() {
        bankingService.addCustomer("John", "Doe", new Date(94,9,6), Gender.MALE, "john.doe@example.com", "123 Elm St.");
        assertEquals(1, bankingService.getAllCustomers().size());
    }

    @Test
    void testAddCardToNonExistingCustomer() {
        // Attempting to add a card to a non-existing customer
        bankingService.addCard(999, "5234567890123456", CardType.MASTERCARD, 5000.0);
        assertEquals(0, bankingService.getAllCards().size());
    }

    @Test
    void testAddCardToExistingCustomer() {
        bankingService.addCustomer("John", "Doe", new Date(110,6,25), Gender.MALE, "john.doe@example.com", "123 Elm St.");
        bankingService.addCard(1, "4234567890123456", CardType.VISA, 5000.0);
        assertEquals(1, bankingService.getAllCards().size());
    }

    @Test
    void testAddTransactionForNonExistingCard() {
        // Expect IllegalArgumentException when card don't exist
        assertThrows(IllegalArgumentException.class, () -> {
            bankingService.addTransaction("4000000000000000", TransactionCode.CODE_BUY, 200.0, new Date());
        });

    }

    @Test
    void testAddValidTransaction() {
        bankingService.addCustomer("John", "Doe", new Date(119,4,18), Gender.MALE, "john.doe@example.com", "123 Elm St.");
        bankingService.addCard(1, "6234567890123456", CardType.VISA, 5000.0);
        bankingService.addTransaction("6234567890123456", TransactionCode.CODE_BUY, 200.0, new Date());
        assertEquals(1, bankingService.getAllTransactions().size());
    }
}
