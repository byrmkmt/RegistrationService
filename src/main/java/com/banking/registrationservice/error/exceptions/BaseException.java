package com.banking.registrationservice.error.exceptions;

import com.banking.registrationservice.error.ErrorCodes;
import com.banking.registrationservice.utility.MessageUtil;

public abstract class BaseException extends RuntimeException {
    private final ErrorCodes code;

    protected BaseException(ErrorCodes code, String message) {
        super(message);
        this.code = code;
    }

    public ErrorCodes getCode() {
        return code;
    }

    public String getCodeAsString() {
        return code.name();
    }

    protected static String formatMessage(ErrorCodes code, Object... args) {
        return MessageUtil.get(code.getKey(), args);
    }
}
