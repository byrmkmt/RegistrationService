package com.banking.loginservice.service;

import com.banking.loginservice.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginRepositoryAccountDetailsService implements LoginDetailsService {
    private LoginRepository accountRepository;

    @Autowired
    public void setAccountRepository(LoginRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username +" not found");
        }
        return account;
    }
}
