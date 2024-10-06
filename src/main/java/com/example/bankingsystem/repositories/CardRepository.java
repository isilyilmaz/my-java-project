package com.example.bankingsystem.repositories;

import com.example.bankingsystem.models.Card;

import java.util.List;
import java.util.Optional;

public class CardRepository extends GenericRepository<Card> {
    // Add any additional card-specific methods if needed

    // Custom method to find a card by its card number
    public Optional<Card> findByCardNo(String cardNo) {
        return entities.stream()
                .filter(card -> card.getCardNo().equals(cardNo))
                .findFirst();
    }
}

