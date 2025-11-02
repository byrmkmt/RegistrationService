package com.banking.registrationservice.model.entity;

import com.banking.registrationservice.model.enums.RegistrationStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "customer_account")
public class CustomerAccount implements Serializable {
    private Long customerId;
    private PersonalInformation personalInformation;
    private Date creationDate;
    private Date lastModifiedDate;
    private RegistrationStatus status;

    public CustomerAccount() {
    }

    public CustomerAccount(RegistrationStatus status, Date lastModifiedDate, Date creationDate, PersonalInformation personalInformation,
                           String branch, String accountNumber, Long customerId) {
        this.status = status;
        this.lastModifiedDate = lastModifiedDate;
        this.creationDate = creationDate;
        this.personalInformation = personalInformation;
        this.customerId = customerId;
    }

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "personal_info_id", nullable = false, foreignKey = @ForeignKey(name = "fk_personal_info"))
    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }

    public void setPersonalInformation(PersonalInformation personalInformation) {
        this.personalInformation = personalInformation;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_update", nullable = false)
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    public RegistrationStatus getStatus() {
        return status;
    }

    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }
}
