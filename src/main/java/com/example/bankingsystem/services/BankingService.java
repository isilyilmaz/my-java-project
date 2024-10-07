package com.example.bankingsystem.services;

import com.example.bankingsystem.enums.CardType;
import com.example.bankingsystem.enums.Gender;
import com.example.bankingsystem.enums.TransactionCode;
import com.example.bankingsystem.models.Card;
import com.example.bankingsystem.models.Customer;
import com.example.bankingsystem.models.Transaction;
import com.example.bankingsystem.repositories.CustomerRepository;
import com.example.bankingsystem.repositories.CardRepository;
import com.example.bankingsystem.repositories.TransactionRepository;
import com.example.bankingsystem.utils.IDGenerator;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

public class BankingService {
    private CustomerRepository customerRepository = new CustomerRepository();
    private CardRepository cardRepository = new CardRepository();
    private TransactionRepository transactionRepository = new TransactionRepository();

    // Add Customer
    public void addCustomer(String name, String surname, Date birthDate, Gender gender, String email, String address) {
        Customer customer = new Customer(IDGenerator.generateCustomerId(), name, surname, birthDate, gender, email, address,null,null);
        customerRepository.add(customer);
    }

    // Add Card
    public void addCard(int customerId, String cardNo, CardType cardType, Date expirationDate,double limit) {

        if (customerRepository.getById(customerId).isPresent()) {
            Card card = new Card(IDGenerator.generateCardId(), customerId, cardNo, cardType, expirationDate,limit,null,null);
            cardRepository.add(card);
        }
    }

    // Add Transaction
    public void addTransaction(String cardNo, TransactionCode transactionCode, double amount, Date date) throws SQLException {
        Card cardObject = null;
        if (!TransactionCode.isValidCode(transactionCode))
            throw new IllegalArgumentException("TransactionCode("+transactionCode.getCode()+") is invalid.");

         if(cardRepository.findByCardNo(cardNo)!=null)
             cardObject = cardRepository.findByCardNo(cardNo);
         else
             throw new IllegalArgumentException("CardNo("+cardNo+") isn't found in Card Lists.");

         if((cardObject != null) && customerRepository.getById(cardObject.getCustomerId()).isPresent())
        {
            Transaction transaction = new Transaction(IDGenerator.generateTransactionId(),cardNo, transactionCode, amount, date,null,null);
            transactionRepository.add(transaction);
        }
         else
             throw new IllegalArgumentException("Customer("+cardObject.getCustomerId()+") isn't found in Customer Lists.");
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAll();
    }

    public List<Card> getAllCards() {
        return cardRepository.getAll();
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.getAll();
    }

    // Other service methods...

    // Search card by card number
    public Card searchCardByNumber(String cardNo) throws SQLException {
        return cardRepository.findByCardNo(cardNo);
    }


}
