package com.banking.registrationservice.model.dto;

import com.banking.registrationservice.model.enums.SuccessCodes;
import com.banking.registrationservice.utility.MessageUtil;

public record RegistrationResponseDTO(Long customerId, String message) {

    public RegistrationResponseDTO(Long customerId, SuccessCodes message) {
        this(customerId, formatMessage(message));
    }

    private static String formatMessage(SuccessCodes code) {
        return MessageUtil.get(code.getKey());
    }
}
