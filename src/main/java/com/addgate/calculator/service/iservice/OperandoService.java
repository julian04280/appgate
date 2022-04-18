package com.addgate.calculator.service.iservice;


import com.addgate.calculator.util.Operators;
import org.springframework.stereotype.Service;

@Service
public interface OperandoService {

    String save(Double value, String idTransaction);
    String result(Operators value, String idTransaction, boolean addResult);
}
