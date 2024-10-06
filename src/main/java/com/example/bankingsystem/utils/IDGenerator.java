package com.example.bankingsystem.utils;

/**
 * A utility class for generating unique, incremental IDs for different entities.
 */
public class IDGenerator {
    // Static counters for each entity type
    private static int customerIdCounter = 0;
    private static int cardIdCounter = 0;
    private static int transactionIdCounter = 0;

    /**
     * Generates a unique ID for the Customer entity.
     *
     * @return a unique customer ID.
     */
    public static synchronized int generateCustomerId() {
        return ++customerIdCounter;
    }

    /**
     * Generates a unique ID for the Card entity.
     *
     * @return a unique card ID.
     */
    public static synchronized int generateCardId() {
        return ++cardIdCounter;
    }

    /**
     * Generates a unique ID for the Transaction entity.
     *
     * @return a unique transaction ID.
     */
    public static synchronized int generateTransactionId() {
        return ++transactionIdCounter;
    }
}
