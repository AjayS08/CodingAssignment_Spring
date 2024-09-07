package com.assignment.test.opeartiontype.division;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.assignment.test.exceptionshandler.DivisionByZeroException;
import com.assignment.test.opeartiontype.OperationType;

public class BigDecimalDivideOperation implements OperationType {

	public static final int SCALE = 15;
	@Override
	public Number execute(Number a, Number b) {
		BigDecimal num1 = toBigDecimal(a);
		BigDecimal num2 = toBigDecimal(b);
		if (num2.compareTo(BigDecimal.ZERO) == 0) {
			throw new DivisionByZeroException("Division by zero is not allowed");
		}
		return num1.divide(num2, SCALE, RoundingMode.HALF_UP);
	}

	private BigDecimal toBigDecimal(Number number) {
		if (number instanceof BigDecimal) {
			return (BigDecimal) number;
		} else {
			return new BigDecimal(number.toString());
		}
	}
}
