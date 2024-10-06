package com.example.bankingsystem.models;

import com.example.bankingsystem.enums.Gender;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;

public class Customer extends BaseEntity {
    private String name;
    private String surname;
    private Date birthDate;
    private Gender gender;
    private String email;
    private String address;

    // Regular expression pattern for email validation
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";

    public Customer(int id, String name, String surname, Date birthDate, Gender gender, String email, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = validateBirthDate(birthDate);
        this.gender = gender;
        this.email = validateEmail(email);
        this.address = address;
    }

    // Getters, Setters, and Validation Logic...

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    private String validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty.");
        }
        // Compile the pattern and match against the email
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid email format: " + email);
        }
        return email;
    }

    // Birthdate validation: cannot be in the future
    private Date validateBirthDate(Date birthDate) {

        if (birthDate == null){
            throw new IllegalArgumentException("Birthdate("+birthDate+") cannot be null.");
        }

        if (birthDate.after(new Date())) {
            throw new IllegalArgumentException("Birthdate("+birthDate+") cannot be in the future.");
        }

        if (birthDate.before(new Date(45,1,1))) {
            throw new IllegalArgumentException("Birthdate("+birthDate+") cannot be before then 19450101.");
        }
        return birthDate;
    }

}
