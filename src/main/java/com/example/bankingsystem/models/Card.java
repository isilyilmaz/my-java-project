package com.example.bankingsystem.models;

public class Card extends BaseEntity {
    private int id;
    private int customerId;
    private String cardNo;
    private String cardType;
    private double cardLimit;

    public Card(int id, int customerId,String cardNo, String cardType, double cardLimit) {
        this.id = id;
        this.cardNo = cardNo;
        this.cardType = cardType;
        this.cardLimit = cardLimit;
    }

    // Getters, Setters, and Validation Logic...
}
