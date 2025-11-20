package com.banking.registrationservice.model.enums;

public enum SuccessCodes {
    PERSONAL_INFORMATION_REGISTERED("success.register_personal_information"),
    CONTACT_INFORMATION_REGISTERED("success.register_contact_information"),
    REGISTER_COMPLETED_SUCCESSFULLY("success.register_complete");

    private final String key;

    SuccessCodes(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

}