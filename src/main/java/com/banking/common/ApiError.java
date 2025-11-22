package com.banking.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiError(
        String code,
        String message,
        LocalDateTime timestamp,
        String path,
        Map<String, String> validationErrors
) {
    public ApiError(String code, String message, String path) {
        this(code, message, LocalDateTime.now(), path, null);
    }

    public ApiError(String code, String path, Map<String, String> validationErrors) {
        this(code, null, LocalDateTime.now(), path, validationErrors);
    }
}
