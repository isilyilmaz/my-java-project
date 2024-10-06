package com.example.bankingsystem.models;

import com.example.bankingsystem.enums.CardType;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Card extends BaseEntity {
    private int id;
    private int customerId;
    private String cardNo;
    private CardType cardType;
    private double cardLimit;

    // Regular expression pattern for email validation
    private static final String CARD_NO_REGEX = "^[4-9][0-9]+$";

    public Card(int id, int customerId,String cardNo, CardType cardType, double cardLimit) {
        this.id = id;
        this.customerId=customerId;
        this.cardNo = validateCardNo(cardNo);
        this.cardType = cardType;
        this.cardLimit = cardLimit;
    }

    // Getters, Setters, and Validation Logic...


    public String getCardNo() {
        return cardNo;
    }

    public int getCustomerId() {
        return customerId;
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
