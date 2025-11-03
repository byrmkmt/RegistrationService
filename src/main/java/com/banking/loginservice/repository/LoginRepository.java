package com.banking.loginservice.repository;

import com.banking.loginservice.model.entity.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginData, Long> {
    UserDetails findByUsername(String username);
}
