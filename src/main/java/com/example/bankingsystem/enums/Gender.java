package com.example.bankingsystem.enums;

public enum Gender {
    CODE_FEMALE("F"),
    CODE_MALE("M");


    private final String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getGender(String gender) {
        for (Gender genderCode : Gender.values()) {
            if (genderCode.getCode().equals(gender)) {
                return genderCode.getCode();
            }
        }
        return null;
    }

    public static boolean isValidCode(Gender code) {
        for (Gender genderCode : Gender.values()) {
            if (genderCode.getCode().equals(code.getCode())) {
                return true;
            }
        }
        return false;
    }
}
