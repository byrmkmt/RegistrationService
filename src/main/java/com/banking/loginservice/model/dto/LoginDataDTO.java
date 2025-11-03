package com.banking.loginservice.model.dto;

import java.io.Serializable;

public class LoginDataDTO implements Serializable {
    private String username;
    private String password;

    public LoginDataDTO() {
    }

    public LoginDataDTO(String username, String password) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;

    }

    public void setPassword(String password) {
        this.password = password;
    }
}
