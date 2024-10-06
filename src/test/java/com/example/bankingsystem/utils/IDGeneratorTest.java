package com.example.bankingsystem.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IDGeneratorTest {

    @Test
    void testGenerateCustomerId() {
        int firstId = IDGenerator.generateCustomerId();
        int secondId = IDGenerator.generateCustomerId();
        assertNotEquals(firstId, secondId);
    }

    @Test
    void testGenerateCardId() {
        int firstId = IDGenerator.generateCardId();
        int secondId = IDGenerator.generateCardId();
        assertNotEquals(firstId, secondId);
    }

    @Test
    void testGenerateTransactionId() {
        int firstId = IDGenerator.generateTransactionId();
        int secondId = IDGenerator.generateTransactionId();
        assertNotEquals(firstId, secondId);
    }
}
