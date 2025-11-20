package com.banking.registrationservice.error;

public enum ErrorCodes {

    CUSTOMER_EXIST("error.customer_exist"),
    ACCOUNT_NUMBER_EXIST("error.account_number_exist"),
    ACCOUNT_NOT_FOUND("error.account_not_found"),
    PERSONAL_INFORMATION_NOT_FOUND("error.personal_information_not_found"),
    CONTACT_INFORMATION_NOT_FOUND("error.contact_information_not_found"),;

    private final String key;

    ErrorCodes(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}