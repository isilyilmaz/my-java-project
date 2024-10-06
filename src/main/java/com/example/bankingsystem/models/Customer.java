package com.example.bankingsystem.models;

import com.example.bankingsystem.enums.Gender;

import java.util.Date;

public class Customer extends BaseEntity {
    private String name;
    private String surname;
    private Date birthDate;
    private Gender gender;
    private String email;
    private String address;

    public Customer(int id, String name, String surname, Date birthDate, Gender gender, String email, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
        this.address = address;
    }

    // Getters, Setters, and Validation Logic...
}
