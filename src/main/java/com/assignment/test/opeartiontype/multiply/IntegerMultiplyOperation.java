package com.assignment.test.opeartiontype.multiply;

import com.assignment.test.opeartiontype.OperationType;

public class IntegerMultiplyOperation implements OperationType {
	@Override
	public Number execute(Number num1, Number num2) {
		int a = num1.intValue();
		int b = num2.intValue();

		if (a == 0 || b == 0) {
			return 0;
		}

		if (a > 0 && b > 0 && a > Integer.MAX_VALUE / b) {
			throw new ArithmeticException("IntegerMultiplyOperation: Integer overflow in multiplication");
		}
		if (a < 0 && b < 0 && a < Integer.MAX_VALUE / b) {
			throw new ArithmeticException("IntegerMultiplyOperation: Integer overflow in multiplication");
		}
		if (a > 0 && b < 0 && b < Integer.MIN_VALUE / a) {
			throw new ArithmeticException("IntegerMultiplyOperation: Integer overflow in multiplication");
		}
		if (a < 0 && b > 0 && a < Integer.MIN_VALUE / b) {
			throw new ArithmeticException("IntegerMultiplyOperation: Integer overflow in multiplication");
		}

		return a * b;
	}
}