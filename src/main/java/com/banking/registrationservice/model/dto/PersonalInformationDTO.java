package com.banking.registrationservice.model.dto;


import java.util.Date;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PersonalInformationDTO {
    private String firstName;
    private String lastName;
    private String tcNumber;
    private Date dateOfBirth;
    private ContactInformationDTO contactInformation;

    public PersonalInformationDTO() {}

    public PersonalInformationDTO(ContactInformationDTO contactInformation, Date dateOfBirth, String tcNumber,
                                  String lastName, String firstName) {
        this.contactInformation = contactInformation;
        this.dateOfBirth = dateOfBirth;
        this.tcNumber = tcNumber;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Pattern(regexp = "^[0-9]+$", message = "Sadece sayı girebilirsiniz")
    @NotBlank(message = "T.C. kimlik numarası boş olamaz.")
    public String getTcNumber() {
        return tcNumber;
    }

    public void setTcNumber(String tcNumber) {
        this.tcNumber = tcNumber;
    }

    @NotNull(message = "Doğum tarihi boş olamaz")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Gecerli isim formatı (harf) giriniz.")
    @NotBlank(message = "İsim boş olamaz.")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Pattern(regexp = "^[a-zA-Z]+$", message = "Gecerli soyisim formatı (harf) giriniz.")
    @NotBlank(message = "Soyisim boş olamaz.")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Valid
    public ContactInformationDTO getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformationDTO contactInformation) {
        this.contactInformation = contactInformation;
    }
}
