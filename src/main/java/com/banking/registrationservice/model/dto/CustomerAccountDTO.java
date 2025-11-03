package com.banking.registrationservice.model.dto;


import com.banking.registrationservice.model.enums.RegistrationStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/*
{
        "accountNumber":"342212331",
        "branch": "Pendik",
        "status":"IN_PROGRESS",
        "personalInformation": {
        "firstName":"Bayram",
        "lastName":"Komut",
        "tcNumber":"33422123",
        "dateOfBirth":"1997-11-07"
        }
}
*/
public class CustomerAccountDTO {
    private Long customerId;
    private String password;
    private PersonalInformationDTO personalInformation;
    private RegistrationStatus status;

    public CustomerAccountDTO() {}

    public CustomerAccountDTO(Long customerId, String password, PersonalInformationDTO personalInformation, RegistrationStatus status) {
        this.customerId = customerId;
        this.password = password;
        this.personalInformation = personalInformation;
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotNull(message = "Personal information boş olamaz.")
    @Valid
    public PersonalInformationDTO getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformationDTO personalInformation) {
        this.personalInformation = personalInformation;
    }

    public RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }
}
