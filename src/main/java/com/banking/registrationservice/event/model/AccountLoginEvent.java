package com.banking.registrationservice.event.model;

import java.util.Date;

public class AccountLoginEvent implements DomainEvent {
    private Date occurredOn;
    private String username;

    public AccountLoginEvent() {}

    public AccountLoginEvent(String username, Date occurredOn) {
        this.username = username;
        this.occurredOn = occurredOn;
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
