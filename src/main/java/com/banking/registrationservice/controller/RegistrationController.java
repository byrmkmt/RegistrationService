package com.banking.registrationservice.controller;

import com.banking.registrationservice.model.dto.AccountInformationDTO;
import com.banking.registrationservice.model.dto.ContactInformationDTO;
import com.banking.registrationservice.model.dto.CustomerAccountDTO;
import com.banking.registrationservice.model.dto.RegistrationResponseDTO;
import com.banking.registrationservice.model.entity.CustomerAccount;
import com.banking.registrationservice.model.enums.SuccessCodes;
import com.banking.registrationservice.service.RegistrationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping("/registrar/personalInfo")
    public ResponseEntity<RegistrationResponseDTO> registerPersonalInformation(
            @RequestBody @Valid @NotNull(message = "Request body cannot be null") CustomerAccountDTO dto) {
        CustomerAccount account = service.savePersonalInformation(dto);

        return buildResponse(
                account.getCustomerId(),
                SuccessCodes.PERSONAL_INFORMATION_REGISTERED,
                HttpStatus.CREATED
        );
    }

    @PostMapping("/registrar/contactInfo/{accountId}")
    public ResponseEntity<RegistrationResponseDTO> registerContactInformation(
            @PathVariable @NotNull(message = "Account ID cannot be null") @Positive(message = "Account ID must be positive")  Long accountId,
            @RequestBody @Valid @NotNull(message = "Request body cannot be null") ContactInformationDTO dto) {
        service.saveContactInformation(accountId, dto);

        return buildResponse(
                accountId,
                SuccessCodes.CONTACT_INFORMATION_REGISTERED,
                HttpStatus.OK
        );
    }

    @PostMapping("/registrar/complete")
    public ResponseEntity<RegistrationResponseDTO> registerComplete(
            @RequestBody @Valid @NotNull(message = "Request body cannot be null")  AccountInformationDTO dto) {
        service.completeRegistration(dto);

        return buildResponse(
                dto.getCustomerId(),
                SuccessCodes.REGISTER_COMPLETED_SUCCESSFULLY,
                HttpStatus.OK
        );
    }

    private ResponseEntity<RegistrationResponseDTO> buildResponse(
            Long customerId,
            SuccessCodes successCode,
            HttpStatus status) {
        RegistrationResponseDTO response =
                new RegistrationResponseDTO(customerId, successCode);
        return ResponseEntity.status(status).body(response);
    }

}
