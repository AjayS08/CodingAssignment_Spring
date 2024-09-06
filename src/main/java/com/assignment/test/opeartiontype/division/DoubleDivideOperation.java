package com.assignment.test.opeartiontype.division;

import com.assignment.test.opeartiontype.OperationType;


public class DoubleDivideOperation implements OperationType {
	@Override
	public Number execute(Number num1, Number num2) {
		if (num2.doubleValue() == 0.0) {
			throw new ArithmeticException("Division by zero is not allowed");
		}

		if (Double.isNaN(num1.doubleValue()) || Double.isNaN(num2.doubleValue())) {
			throw new ArithmeticException("Invalid operation: NaN encountered");
		}

		double result = num1.doubleValue() / num2.doubleValue();

		return result;
	}
}