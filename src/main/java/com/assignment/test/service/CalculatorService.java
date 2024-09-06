package com.assignment.test.service;

import java.util.List;
import com.assignment.test.operation.Calculator;
import com.assignment.test.operation.ChainedCalculator;
import com.assignment.test.enums.Operation;
import com.assignment.test.exceptionshandler.CalculationException;
import com.assignment.test.datamodel.CalculateRequest;
import com.assignment.test.datamodel.ChainRequest;
import com.assignment.test.datamodel.OperationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

	private final Calculator calculator;
	private final ChainedCalculator chainedCalculator;
	private final ValidationService validationService;

	@Autowired
	public CalculatorService(Calculator calculator, ChainedCalculator chainedCalculator,
			ValidationService validationService) {
		this.calculator = calculator;
		this.chainedCalculator = chainedCalculator;
		this.validationService = validationService;
	}

	public Number calculate(CalculateRequest calculateRequest) {
		validationService.validateCalculateRequest(calculateRequest);
		Operation operation = validationService.validateAndParseOperation(calculateRequest.getOpeartion());

		Number result = null;
		Number a = null;
		Number b = null;
		try {
			a = calculateRequest.getNumber1();
			b = calculateRequest.getNumber2();
			result = calculator.calculate(operation, a, b);
		} catch (Exception e) {
			throw new CalculationException("Failed to execute calculation", e);
		}

		if (result == null) {
			throw new CalculationException("Failed to execute calculation");
		}
		return result;
	}


	public Number calculateChain(ChainRequest chainRequest) {
		validationService.validateChainRequest(chainRequest);
		Number initialValue = null;
		List<OperationRequest> operations = null;

		try {
			initialValue = chainRequest.getInitialValue() != null ? chainRequest.getInitialValue() : 0;
			operations = chainRequest.getOperations();

			chainedCalculator.start(initialValue);
			for (OperationRequest operationRequest : operations) {
				Operation operation = validationService.validateAndParseOperation(operationRequest.getOpeartion());
				chainedCalculator.apply(operation, operationRequest.getNumber());
			}
			return chainedCalculator.getResult();
		} catch (Exception e) {
			throw new CalculationException("Failed to execute chained calculation", e);
		}
	}
}