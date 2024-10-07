package com.example.bankingsystem.models;

import com.example.bankingsystem.enums.CardType;

import java.sql.Timestamp;
import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Card extends BaseEntity {
    private int id;
    private int customerId;
    private String cardNo;
    private CardType cardType;
    private Date expirationDate;
    private double cardLimit;

    // Regular expression pattern for email validation
    private static final String CARD_NO_REGEX = "^[4-9][0-9]+$";

    public Card(int id, int customerId, String cardNo, CardType cardType, Date expiration_date,double cardLimit, Timestamp createdAt, Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.customerId=customerId;
        this.cardNo = validateCardNo(cardNo);
        this.cardType = cardType;
        this.expirationDate = expiration_date;
        this.cardLimit = cardLimit;
    }

    // Getters, Setters, and Validation Logic...


    public String getCardNo() {
        return cardNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public CardType getCardType() {
        return cardType;
    }

    public double getCardLimit() {
        return cardLimit;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    private String validateCardNo(String cardNo) {
        Pattern pattern = Pattern.compile(CARD_NO_REGEX);
        if (cardNo.isEmpty()){
            throw new IllegalArgumentException("Card No("+cardNo+") can't be null.");
        }

        if (cardNo.length()<16 || cardNo.length()>20){
            throw new IllegalArgumentException("Card No Length("+cardNo.length()+") can be between 16-20.");
        }

        Matcher matcher = pattern.matcher(cardNo);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid card no format: " + cardNo);
        }

        return cardNo;
    }
}
