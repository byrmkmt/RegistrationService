package com.banking.registrationservice.model.dto;

import jakarta.validation.constraints.NotBlank;

public class AccountInformationDTO {
    private long customerId;
    private String password;

    public AccountInformationDTO() {}

    public AccountInformationDTO(long customerId, String password) {
        this.customerId = customerId;
        this.password = password;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    @NotBlank(message = "Şifre boş olamaz.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
