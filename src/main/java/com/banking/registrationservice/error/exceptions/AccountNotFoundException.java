package com.banking.registrationservice.error.exceptions;

import com.banking.registrationservice.error.ErrorCodes;

public class AccountNotFoundException extends BaseException {

    private AccountNotFoundException(ErrorCodes code, String message) {
        super(code, message);
    }

    public static AccountNotFoundException of(ErrorCodes code, Object... args) {
        return new AccountNotFoundException(code, formatMessage(code, args));
    }

}
