package com.assignment.test.operation;

import com.assignment.test.enums.Operation;
import com.assignment.test.opeartiontype.OperationType;
import com.assignment.test.opeartiontype.OpeartionFactory;
import org.springframework.stereotype.Service;


@Service
public class Calculator {

	public Number calculate(Operation operation, Number num1, Number num2) {
		OperationType opeartion = OpeartionFactory.getStrategy(operation, num1, num2);

		if (opeartion == null) {
			throw new UnsupportedOperationException("Operation not supported: " + operation);
		}

		return opeartion.execute(num1, num2);
	}
}
