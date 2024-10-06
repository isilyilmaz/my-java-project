package com.example.bankingsystem;

import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.enums.TransactionCode;
import com.example.bankingsystem.repositories.TransactionRepository;
import com.example.bankingsystem.services.BankingService;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        BankingService service = new BankingService();

        // Add a customer
        service.addCustomer("Alice", "Smith", new Date(800000000000L), Gender.FEMALE, "alice.smith@example.com", "456 Maple St.");

        // Add a card
        service.addCard(1, "1111-2222-3333-4444", "MasterCard", 10000.0);

        // Add a transaction
        service.addTransaction("1111-2222-3333-4444", TransactionCode.CODE_BUY, 500.0, new Date());

        // Other operations...
    }
}
