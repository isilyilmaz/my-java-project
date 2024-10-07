package com.example.bankingsystem.models;

import com.example.bankingsystem.enums.Gender;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomerTest {

    @Test
    void testValidEmailAndBirthDate() {
        Customer customer = new Customer(1, "John", "Doe", new Date(119,9,6), Gender.CODE_MALE, "john.doe@example.com", "123 Elm St.",null,null);
        assert(customer.getEmail().equals("john.doe@example.com"));
    }

    @Test
    void testInvalidEmail_NoAtSymbol() {
        // Expect IllegalArgumentException when email is missing '@'
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(2, "Alice", "Smith", new Date(101,11,20), Gender.CODE_FEMALE, "alice.example.com", "456 Maple St.",null,null);
        });
    }

    @Test
    void testInvalidEmail_EmptyEmail() {
        // Expect IllegalArgumentException when email is empty
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(3, "Bob", "Johnson", new Date(94,6,15), Gender.CODE_MALE, "", "789 Oak St.",null,null);
        });
    }

    @Test
    void testInvalidEmail_NullEmail() {
        // Expect IllegalArgumentException when email is null
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(4, "Charlie", "Brown", new Date(111,3,18), Gender.CODE_MALE, null, "123 Pine St.",null,null);
        });
    }

    @Test
    void testInvalidEmail_NoTopLevelDomain() {
        // Expect IllegalArgumentException when email is missing top-level domain
        assertThrows(IllegalArgumentException.class, () -> {
            new Customer(5, "David", "Miller", new Date(107,8,2), Gender.CODE_MALE, "david@example", "654 Birch St.",null,null);
        });
    }

    @Test
    void testNullBirthDate() {
        // Expect IllegalArgumentException when email is missing top-level domain
        assertThrows(IllegalArgumentException.class, () -> {
          new Customer(5, "David", "Miller", null, Gender.CODE_MALE, "david@example", "654 Birch St.",null,null);
        });

    }

    @Test
    void testBeforeDateBirthDate() {
        // Expect IllegalArgumentException when email is missing top-level domain
        assertThrows(IllegalArgumentException.class, () -> {
        new Customer(5, "David", "Miller", new Date(23,2,4), Gender.CODE_MALE, "david@example", "654 Birch St.",null,null);
        });
    }

    @Test
    void testAfterDateBirthDate() {
        // Expect IllegalArgumentException when email is missing top-level domain
        assertThrows(IllegalArgumentException.class, () -> {
        new Customer(5, "David", "Miller", new Date(126,1,1), Gender.CODE_MALE, "david@example", "654 Birch St.",null,null);
        });
    }
}
