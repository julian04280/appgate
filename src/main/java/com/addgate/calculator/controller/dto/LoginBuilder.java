package com.addgate.calculator.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginBuilder {

    private String email;
    private String password;
    private String jwt;

    public LoginBuilder(){}

    public LoginBuilder email( String email) {
        this.email = email;
        return this;
    }

    public LoginBuilder password( String password) {
        this.password = password;
        return this;
    }

    public LoginBuilder jwt( String jwt) {
        this.jwt = jwt;
        return this;
    }

    public LoginDto build() {
        return new LoginDto(this);
    }

}
