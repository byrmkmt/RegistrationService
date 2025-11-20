package com.banking.registrationservice.error.exceptions;

import com.banking.registrationservice.error.ErrorCodes;

public class AccountExistsException extends BaseException {

    private AccountExistsException(ErrorCodes code, String message) {
        super(code, message);
    }

    public static AccountExistsException of(ErrorCodes code, Object... args) {
        return new AccountExistsException(code, formatMessage(code, args));
    }

}
