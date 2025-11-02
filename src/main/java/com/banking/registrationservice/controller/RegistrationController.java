package com.banking.registrationservice.controller;

import com.banking.registrationservice.model.dto.ContactInformationDTO;
import com.banking.registrationservice.model.dto.CustomerAccountDTO;
import com.banking.registrationservice.model.entity.CustomerAccount;
import com.banking.registrationservice.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "http://localhost:5173")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service) {
        this.service = service;
    }

    @PostMapping("/registrar/personalInfo")
    public ResponseEntity<?> registrarPersonalInformation(@RequestBody @Valid CustomerAccountDTO dto) {
        CustomerAccount account = service.savePersonalInformation(dto);
        return ResponseEntity.ok(Map.of("Customer Id", account.getCustomerId(), "message", "Personal information saved"));
    }

    @PostMapping("/registrar/contactInfo/{accountId}")
    public ResponseEntity<?> registrarCustomerInformation(@PathVariable Long accountId, @RequestBody @Valid ContactInformationDTO dto) {
        CustomerAccount account = service.saveContactInformation(accountId, dto);
        return ResponseEntity.ok(Map.of("Customer Id", account.getCustomerId(), "message", "Contact information saved"));
    }

    @PostMapping("/registrar/complete/{accountId}")
    public ResponseEntity<?> registrarSetComplete(@PathVariable Long accountId) {
        CustomerAccount account = service.completeRegistration(accountId);
        return ResponseEntity.ok(Map.of("Customer Id", account.getCustomerId(), "message", "Registration complete"));
    }
}
