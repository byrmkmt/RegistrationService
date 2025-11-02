package com.banking.registrationservice.model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@Table(name = "personal_informations")
public class PersonalInformation {
    private Long id;
    private String firstName;
    private String lastName;
    private String tcNumber;
    private Date dateOfBirth;
    private Date createdDate;
    private Date lastModifiedDate;
    private ContactInformation contactInformation;

    public PersonalInformation() {}

    public PersonalInformation(Long id, String firstName, String lastName, String tcNumber,
                               Date dateOfBirth, ContactInformation contactInformation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.tcNumber = tcNumber;
        this.dateOfBirth = dateOfBirth;
        this.contactInformation = contactInformation;
    }

    @Id
    @Column(name = "personal_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "tc_number", nullable = false)
    public String getTcNumber() {
        return tcNumber;
    }

    public void setTcNumber(String tcNumber) {
        this.tcNumber = tcNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_of_birth", nullable = false, updatable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_info_id", foreignKey = @ForeignKey(name = "fk_contact_info"))
    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PersonalInformation other = (PersonalInformation) obj;
        if(tcNumber == null || other.tcNumber == null){
            return false;
        }
        return tcNumber.equals(other.tcNumber);
    }
}
