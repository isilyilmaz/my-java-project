package com.example.bankingsystem.enums;

import com.example.bankingsystem.repositories.TransactionRepository;

public enum TransactionCode {
    CODE_BUY("05"),
    CODE_REFUND_OF_SELL("06"),
    CODE_DEPOSIT("07"),
    CODE_MONEY_TRANSFER("08"),
    CODE_CB_BUY("15"),
    CODE_CB_REFUND_OF_SELL("16"),
    CODE_CB_DEPOSIT("17"),
    CODE_CB_MONEY_TRANSFER("18"),
    CODE_REV_BUY("25"),
    CODE_REV_REFUND_OF_SELL("26"),
    CODE_REV_DEPOSIT("27"),
    CODE_REV_MONEY_TRANSFER("28");

    private final String code;

    TransactionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static boolean isValidCode(TransactionCode code) {
        for (TransactionCode transactionCode : TransactionCode.values()) {
            if (transactionCode.getCode().equals(code.getCode())) {
                return true;
            }
        }
        return false;
    }
}
