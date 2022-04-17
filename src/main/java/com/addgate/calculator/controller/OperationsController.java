package com.addgate.calculator.controller;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OperationsController {


    @GetMapping("/api/operando")
    public ResponseEntity<String> getOperando(@RequestAttribute("claims") final Claims claims) {
        return new ResponseEntity<String>("Prueba Token " + claims.getSubject(), HttpStatus.OK);
    }
}
