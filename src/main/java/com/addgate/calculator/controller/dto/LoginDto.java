package com.addgate.calculator.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LoginDto {

    private String email;
    private String password;
    private String jwt;

    LoginDto(LoginBuilder builder) {
        this.email = builder.getEmail();
        this.password = builder.getPassword();
        this.jwt = builder.getJwt();
    }
}
