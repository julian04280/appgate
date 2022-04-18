package com.addgate.calculator.controller;

import com.addgate.calculator.service.iservice.OperandoService;
import com.addgate.calculator.util.Operators;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OperationsController {

    @Autowired
    private OperandoService operandoService;

    @PostMapping("/api/operando/{value}")
    public ResponseEntity<String> getOperando(@RequestAttribute("claims") final Claims claims, @PathVariable Double value) {
        return new ResponseEntity<String>(operandoService.save(value, claims.getSubject()), HttpStatus.OK);
    }

    @PostMapping("/api/resultado/{value}")
    public ResponseEntity<String> getResult(@RequestAttribute("claims") final Claims claims, @PathVariable("value") Operators value, @RequestParam boolean addResult) {
        return new ResponseEntity<String>(operandoService.result(value, claims.getSubject(), addResult), HttpStatus.OK);
    }
}
