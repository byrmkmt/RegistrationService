package com.banking.registrationservice.event.model;

import java.util.Date;

public class AccountCreatedEvent implements DomainEvent {
    private Date occurredOn;
    private String userId;
    private String accountNumber;
    private String firstName;
    private String lastName;
    private String status;
    private Date createdDate;
    private Date lastUpdatedDate;

    public AccountCreatedEvent() {}

    public AccountCreatedEvent(Date occurredOn, String userId, String accountNumber, String firstName, String lastName, String status, Date createdDate, Date lastUpdatedDate) {
        this.occurredOn = occurredOn;
        this.userId = userId;
        this.accountNumber = accountNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Date getOccurredOn() {
        return occurredOn;
    }

    public void setOccurredOn(Date occurredOn) {
        this.occurredOn = occurredOn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}
