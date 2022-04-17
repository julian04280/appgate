package com.addgate.calculator.service;

import com.addgate.calculator.controller.dto.LoginDto;
import com.addgate.calculator.repository.SpringDataLoginRepository;
import com.addgate.calculator.repository.entity.LoginEntity;
import com.addgate.calculator.service.iservice.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class LoginImplService implements LoginService {

    @Autowired
    private SpringDataLoginRepository springDataLoginRepository;

    @Override
    public LoginEntity find(LoginDto loginDto) {

        return springDataLoginRepository.findByEmailAndPassword(loginDto.getEmail(),loginDto.getPassword());

    }
}
