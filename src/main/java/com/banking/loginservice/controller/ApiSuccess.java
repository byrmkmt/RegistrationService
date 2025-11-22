package com.banking.loginservice.controller;

import java.time.LocalDateTime;

public record ApiSuccess(String message, LocalDateTime timestamp) {

    public ApiSuccess(String message) {
        this(message, LocalDateTime.now());
    }

}
