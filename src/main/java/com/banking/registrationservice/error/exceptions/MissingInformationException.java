package com.banking.registrationservice.error.exceptions;

import com.banking.registrationservice.error.ErrorCodes;

public class MissingInformationException extends BaseException {

    private MissingInformationException(ErrorCodes code, String message) {
        super(code, message);
    }

    public static MissingInformationException of(ErrorCodes code, Object... args) {
        return new MissingInformationException(code, formatMessage(code, args));
    }

}
