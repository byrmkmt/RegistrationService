package com.banking.registrationservice.utility;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class MessageUtil {

    private static MessageSourceAccessor accessor;

    public MessageUtil(MessageSource messageSource) {
        accessor = new MessageSourceAccessor(messageSource);
    }

    public static String get(String key, Object... args) {
        return accessor.getMessage(key, args);
    }

    public String getMessage(String key, Object... args) {
        return accessor.getMessage(key, args);
    }
}