package com.example.bankingsystem.models;

import com.example.bankingsystem.enums.TransactionCode;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction extends BaseEntity {
    private int id;
    private String cardNo;
    private TransactionCode transactionCode;
    private double amount;
    private Date date;

    public Transaction(int id, String cardNo, TransactionCode transactionCode, double amount, Date date, Timestamp createdAt, Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.cardNo = cardNo;
        this.transactionCode = transactionCode;
        this.amount = amount;
        this.date = date;
    }

    // Getters, Setters, and Validation Logic...
}
