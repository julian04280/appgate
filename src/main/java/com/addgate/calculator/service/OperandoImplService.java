package com.addgate.calculator.service;

import com.addgate.calculator.controller.dto.LoginDto;
import com.addgate.calculator.repository.SpringDataLoginRepository;
import com.addgate.calculator.repository.SpringDataOperandoRepository;
import com.addgate.calculator.repository.entity.LoginEntity;
import com.addgate.calculator.repository.entity.OperandoEntity;
import com.addgate.calculator.service.iservice.OperandoService;
import com.addgate.calculator.util.Operators;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class OperandoImplService implements OperandoService {

    @Autowired
    private SpringDataOperandoRepository springDataOperandoRepository;

    @Override
    public String save(Double value, String idTransaction) {

        String out = "ok";

        try {
            OperandoEntity operandoEntity = new OperandoEntity();
            operandoEntity.setValue(value);
            operandoEntity.setIdTransaction(idTransaction);
            springDataOperandoRepository.save(operandoEntity);
        }catch (Exception e){
            out = null;
        }

        return out;
    }

    @Override
    public String result(Operators value, String idTransaction, boolean addResult) {

        List<OperandoEntity> lst = springDataOperandoRepository.findByIdTransaction(idTransaction);

        for(OperandoEntity operando: lst){
            springDataOperandoRepository.deleteById(operando.getId());
        }

        double total = 0;

        if(!lst.isEmpty()){
            if(Operators.SUMA.equals(value)){
                for(OperandoEntity operando: lst){
                    total += operando.getValue();
                }
            } else if (Operators.RESTA.equals(value)){
                total = lst.get(0).getValue();
                lst.remove(lst.get(0));
                for(OperandoEntity operando: lst){
                    total -= operando.getValue();
                }
            } else if (Operators.MULTIPLICACION.equals(value)){
                total = lst.get(0).getValue();
                lst.remove(lst.get(0));
                for(OperandoEntity operando: lst){
                    total *= operando.getValue();
                }
            } else if (Operators.DIVISION.equals(value)){
                total = lst.get(0).getValue();
                lst.remove(lst.get(0));
                for(OperandoEntity operando: lst){
                    total /= operando.getValue();
                }
            } else if (Operators.POTENCIACION.equals(value)){
                total = lst.get(0).getValue();
                lst.remove(lst.get(0));
                for(OperandoEntity operando: lst){
                    total = Math.pow(total,operando.getValue());
                }
            }
        }

        if(addResult){
            this.save(total,idTransaction);
        }

        return String.valueOf(total);

    }

}
