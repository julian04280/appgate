package com.addgate.calculator.service;

import com.addgate.calculator.service.iservice.OperandoService;
import com.addgate.calculator.util.Operators;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class OperandoImplServiceTests {

	@Autowired
	OperandoService operandoService;

	@Test
	public void resultSuma() {

		operandoService.save(2.0,"1");
		operandoService.save(3.0,"1");

		String out = operandoService.result(Operators.SUMA,"1",false);

		assertEquals("5.0", out);

	}

	@Test
	public void resultResta() {

		operandoService.save(2.0,"1");
		operandoService.save(3.0,"1");

		String out = operandoService.result(Operators.RESTA,"1",false);

		assertEquals("-1.0", out);

	}

	@Test
	public void resultMultiplicacion() {

		operandoService.save(2.0,"1");
		operandoService.save(3.0,"1");

		String out = operandoService.result(Operators.MULTIPLICACION,"1",false);

		assertEquals("6.0", out);

	}

	@Test
	public void resultDivision() {

		operandoService.save(2.0,"1");
		operandoService.save(3.0,"1");

		String out = operandoService.result(Operators.DIVISION,"1",false);

		assertEquals("0.6666666666666666", out);

	}

	@Test
	public void resultPotenciacion() {

		operandoService.save(2.0,"1");
		operandoService.save(3.0,"1");

		String out = operandoService.result(Operators.POTENCIACION,"1",false);

		assertEquals("8.0", out);

	}

}
