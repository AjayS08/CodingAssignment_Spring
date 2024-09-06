package com.assignment.test.opeartiontype.division;

import com.assignment.test.opeartiontype.OperationType;


public class IntegerDivideOperation implements OperationType {
	@Override
	public Number execute(Number num1, Number num2) {
		if (num2.intValue() == 0) {
			throw new ArithmeticException("Division by zero is not allowed");
		}
		// (-2147483648) / -1 = 2147483648, greater than Integer.MAX_VALUE
		if (num1.intValue() == Integer.MIN_VALUE && num2.intValue() == -1) {
			throw new ArithmeticException("Integer overflow in division");
		}

		// Convert to double to maintain precision in division
		return num1.doubleValue() / num2.doubleValue();
	}
}