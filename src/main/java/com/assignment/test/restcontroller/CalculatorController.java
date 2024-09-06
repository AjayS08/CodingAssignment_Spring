package com.assignment.test.restcontroller;

import com.assignment.test.datamodel.CalculateRequest;
import com.assignment.test.datamodel.ChainRequest;
import com.assignment.test.datamodel.Response;
import com.assignment.test.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

	private final CalculatorService calculatorService;

	@Autowired
	public CalculatorController(CalculatorService calculatorService) {
		this.calculatorService = calculatorService;
	}

	@PostMapping("/calculate")
	public Response calculate(@RequestBody CalculateRequest calculateRequest) {

		Number result = calculatorService.calculate(calculateRequest);
		return Response.builder().code("200").message("Calculation successful").data(result).build();
	}

	@PostMapping("/chainCalculate")
	public Response chainOperations(@RequestBody ChainRequest chainRequest) {
		Number result = calculatorService.calculateChain(chainRequest);
		return Response.builder().code("200").message("Chained calculation successful").data(result).build();
	}
}