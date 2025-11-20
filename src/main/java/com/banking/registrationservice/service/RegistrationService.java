package com.banking.registrationservice.service;

import com.banking.loginservice.model.entity.LoginData;
import com.banking.registrationservice.error.ErrorCodes;
import com.banking.registrationservice.error.exceptions.AccountNotFoundException;
import com.banking.registrationservice.error.exceptions.AccountExistsException;
import com.banking.registrationservice.error.exceptions.MissingInformationException;
import com.banking.registrationservice.event.model.AccountCreatedEvent;
import com.banking.registrationservice.event.publisher.DomainEventPublisher;
import com.banking.registrationservice.model.dto.AccountInformationDTO;
import com.banking.registrationservice.model.dto.ContactInformationDTO;
import com.banking.registrationservice.model.dto.CustomerAccountDTO;
import com.banking.registrationservice.model.entity.ContactInformation;
import com.banking.registrationservice.model.entity.CustomerAccount;
import com.banking.registrationservice.model.entity.PersonalInformation;
import com.banking.registrationservice.model.enums.RegistrationStatus;
import com.banking.registrationservice.repository.RegistrationRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * 333555666
 * 11111
 */

@Service
public class RegistrationService {

    private final DomainEventPublisher publisher;
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository, DomainEventPublisher publisher) {
        this.registrationRepository = registrationRepository;
        this.publisher = publisher;
    }

    /**
     * Personal Information
      */
    public CustomerAccount savePersonalInformation(CustomerAccountDTO dto) {
        CustomerAccount account = new CustomerAccount();
        account.setCustomerId(dto.getCustomerId());
        PersonalInformation personalInfo = new PersonalInformation();
        personalInfo.setFirstName(dto.getPersonalInformation().getFirstName());
        personalInfo.setLastName(dto.getPersonalInformation().getLastName());
        personalInfo.setTcNumber(dto.getPersonalInformation().getTcNumber());
        personalInfo.setDateOfBirth(dto.getPersonalInformation().getDateOfBirth());
        account.setStatus(RegistrationStatus.IN_PROGRESS);
        account.setPersonalInformation(personalInfo);
        if(registrationRepository.findByPersonalInformation_TcNumberAndStatus(personalInfo.getTcNumber(), RegistrationStatus.COMPLETE).isPresent()) {
            throw AccountExistsException.of(ErrorCodes.CUSTOMER_EXIST,account.getCustomerId());
        } else {
            Optional<CustomerAccount> mayBeCurrent = registrationRepository.findByPersonalInformation_TcNumberAndStatus(personalInfo.getTcNumber(), RegistrationStatus.IN_PROGRESS);
            if(mayBeCurrent.isPresent()) {
                if(mayBeCurrent.get().getCustomerId().equals(account.getCustomerId()))
                    return registrationRepository.save(account);
                else
                    throw AccountExistsException.of(ErrorCodes.ACCOUNT_NUMBER_EXIST,account.getCustomerId());
            }
        }
        return registrationRepository.save(account);
    }

    /**
     * Contact Information
     */
    @Transactional
    public void saveContactInformation(Long accountId, ContactInformationDTO dto) {
        CustomerAccount account = registrationRepository.findById(accountId)
                .orElseThrow(() -> AccountNotFoundException.of(ErrorCodes.ACCOUNT_NOT_FOUND));
        ContactInformation contact = new ContactInformation();
        contact.setEmail(dto.getEmail());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setOpenAddress(dto.getOpenAddress());
        account.getPersonalInformation().setContactInformation(contact);
    }

    // Step 3: Complete
    @Transactional
    public void completeRegistration(AccountInformationDTO dto) {
        CustomerAccount account = registrationRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> AccountNotFoundException.of(ErrorCodes.ACCOUNT_NOT_FOUND));
        if (account.getPersonalInformation() == null) {
            throw MissingInformationException.of(ErrorCodes.PERSONAL_INFORMATION_NOT_FOUND);
        }
        if (account.getPersonalInformation().getContactInformation() == null) {
            throw MissingInformationException.of(ErrorCodes.CONTACT_INFORMATION_NOT_FOUND);
        }
        account.setLoginData(new LoginData(account.getPersonalInformation().getTcNumber(), dto.getPassword()));
        account.setStatus(RegistrationStatus.COMPLETE);
        publisher.publish(new AccountCreatedEvent(new Date(),
                account.getPersonalInformation().getTcNumber(),
                account.getCustomerId().toString(),
                account.getPersonalInformation().getFirstName(),
                account.getPersonalInformation().getLastName(),
                "ACTIVATE",
                account.getCreationDate(),
                account.getLastModifiedDate()
        ));
    }
}