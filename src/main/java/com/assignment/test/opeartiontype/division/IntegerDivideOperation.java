package com.assignment.test.opeartiontype.division;

import com.assignment.test.opeartiontype.OperationType;


public class IntegerDivideOperation implements OperationType {
	@Override
	public Number execute(Number num1, Number num2) {
		if (num2.intValue() == 0) {
			throw new ArithmeticException("Division by zero is not allowed");
		}
		
		if (num1.intValue() == Integer.MIN_VALUE && num2.intValue() == -1) {
			throw new ArithmeticException("Integer overflow in division");
		}

		return num1.doubleValue() / num2.doubleValue();
	}
}
