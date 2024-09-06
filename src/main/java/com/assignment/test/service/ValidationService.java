package com.assignment.test.service;

import java.util.List;

import com.assignment.test.exceptionshandler.UnsupportedOperationException;
import com.assignment.test.enums.Operation;
import com.assignment.test.datamodel.CalculateRequest;
import com.assignment.test.datamodel.ChainRequest;
import com.assignment.test.datamodel.OperationRequest;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	public void validateCalculateRequest(CalculateRequest calculateRequest) {
		Operation operation = validateAndParseOperation(calculateRequest.getOpeartion());
		Number num1 = calculateRequest.getNumber1();
		Number num2 = calculateRequest.getNumber2();

		validateOperation(operation);
		validateInputs(num1, num2);
	}

	public void validateChainRequest(ChainRequest chainRequest) {
		List<OperationRequest> operations = chainRequest.getOperations();
		validateInputs(operations);
	}

	public void validateOperation(Operation operation) {
		if (operation == null) {
			throw new UnsupportedOperationException("Invalid operation: operation cannot be null or operation not supported");
		}
	}

	public void validateInputs(Number num1, Number num2) {
		if (num1 == null || num2 == null) {
			throw new UnsupportedOperationException("Invalid input: Numbers cannot be null");
		}
		if (num2.doubleValue() == 0.0 && num2.doubleValue() == 0.0) {
			throw new UnsupportedOperationException("Invalid input: Divisor cannot be 0");
		}
	}

	public void validateInputs(List<OperationRequest> operations) {
		if (operations == null || operations.isEmpty()) {
			throw new UnsupportedOperationException("Invalid operation list: Operation list cannot be null or empty");
		}
		for (OperationRequest operationRequest : operations) {
			validateAndParseOperation(operationRequest.getOpeartion());
			if (operationRequest.getNumber() == null) {
				throw new UnsupportedOperationException("Invalid operation request: Operation and number cannot be null");
			}
		}
	}

	public Operation validateAndParseOperation(String operationStr) {
		try {
			return Operation.valueOf(operationStr.toUpperCase());
		} catch (IllegalArgumentException e) {
			throw new UnsupportedOperationException("Invalid operation: " + operationStr + ". Supported operations are: ADD, SUBTRACT, MULTIPLY, DIVIDE.");
		}
	}
}
