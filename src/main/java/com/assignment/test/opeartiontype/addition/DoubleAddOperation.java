package com.assignment.test.opeartiontype.addition;

import com.assignment.test.opeartiontype.OperationType;

public class DoubleAddOperation implements OperationType {

	@Override
	public Number execute(Number num1, Number num2) {
		// Convert both numbers to double for the operation
		double a = num1.doubleValue();
		double b = num2.doubleValue();
		double result = a + b;

		// Check for overflow
		if (Double.isInfinite(result) || Double.isNaN(result)) {
			throw new ArithmeticException("Double overflow or invalid result");
		}

		return result;
	}
}
