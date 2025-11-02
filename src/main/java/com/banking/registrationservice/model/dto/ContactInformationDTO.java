package com.banking.registrationservice.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/*
 {
     "phoneNumber":"08763332",
     "email":"dddd.gmail.com",
     "openAddress":"Stret"
 }
 */
public class ContactInformationDTO {
    private String phoneNumber;
    private String email;
    private String openAddress;

    public ContactInformationDTO() {}

    public ContactInformationDTO(String phoneNumber, String email, String openAddress) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.openAddress = openAddress;
    }

    @Pattern(regexp = "^[0-9]+$", message = "Sadece sayı girebilirsiniz")
    @NotBlank(message = "Cep numarası boş olamaz.")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Email(message = "Hatalı email formatı.")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotBlank(message = "Açık adres boş olamaz.")
    public String getOpenAddress() {
        return openAddress;
    }

    public void setOpenAddress(String openAddress) {
        this.openAddress = openAddress;
    }
}
