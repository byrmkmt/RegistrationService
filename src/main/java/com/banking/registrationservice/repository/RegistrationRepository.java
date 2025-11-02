package com.banking.registrationservice.repository;

import com.banking.registrationservice.model.entity.CustomerAccount;
import com.banking.registrationservice.model.enums.RegistrationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<CustomerAccount, Long> {

    Optional<CustomerAccount> findByPersonalInformation_TcNumberAndStatus(String tcNumber, RegistrationStatus status);
}
