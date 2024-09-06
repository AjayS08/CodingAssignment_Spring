package com.assignment.test.opeartiontype.multiply;

import com.assignment.test.opeartiontype.OperationType;

public class DoubleMultiplyOperation implements OperationType {
	@Override
	public Number execute(Number num1, Number num2) {
		double result = num1.doubleValue() * num2.doubleValue();
		if (Double.isInfinite(result)) {
			throw new ArithmeticException("DoubleMultiplyOperation: Double overflow in multiplication");
		}
		return result;
	}
}