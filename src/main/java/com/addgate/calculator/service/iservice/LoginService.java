package com.addgate.calculator.service.iservice;


import com.addgate.calculator.controller.dto.LoginDto;
import com.addgate.calculator.repository.entity.LoginEntity;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    LoginEntity find(LoginDto loginDto);
}
