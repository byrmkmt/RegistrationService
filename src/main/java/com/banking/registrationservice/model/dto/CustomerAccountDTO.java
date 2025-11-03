package com.banking.registrationservice.model.dto;


import com.banking.loginservice.model.dto.LoginDataDTO;
import com.banking.registrationservice.model.enums.RegistrationStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class CustomerAccountDTO {
    private Long customerId;
    private LoginDataDTO loginData;
    private PersonalInformationDTO personalInformation;
    private RegistrationStatus status;

    public CustomerAccountDTO() {}

    public CustomerAccountDTO(Long customerId, LoginDataDTO loginData, PersonalInformationDTO personalInformation, RegistrationStatus status) {
        this.customerId = customerId;
        this.loginData = loginData;
        this.personalInformation = personalInformation;
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public LoginDataDTO getLoginData() {
        return loginData;
    }

    public void setLoginData(LoginDataDTO loginData) {
        this.loginData = loginData;
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
