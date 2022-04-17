package com.addgate.calculator.controller;

import com.addgate.calculator.controller.dto.LoginBuilder;
import com.addgate.calculator.controller.dto.LoginDto;
import com.addgate.calculator.repository.entity.LoginEntity;
import com.addgate.calculator.service.iservice.LoginService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@RestController
public class LoginController {

    @Value("${jwt.secret}")
    private String secret;

    @Autowired
    private LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LoginDto> login(@RequestBody final LoginDto login) throws ServletException {

        LoginEntity loginEntity = loginService.find(login);

        final boolean existUser = loginEntity != null ? true : false;

        if (!existUser) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        final Instant now = Instant.now();

        final String jwt = Jwts.builder()
                .setSubject(loginEntity.getId().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(1, ChronoUnit.DAYS)))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(secret))
                .compact();

        LoginDto loginDto = new LoginBuilder().email(loginEntity.getEmail())
                .password(loginEntity.getPassword())
                .jwt(jwt).build();

        return new ResponseEntity<LoginDto>(loginDto, HttpStatus.OK);
    }

}
