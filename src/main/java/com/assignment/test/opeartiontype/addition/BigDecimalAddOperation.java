package com.assignment.test.opeartiontype.addition;


import java.math.BigDecimal;
import com.assignment.test.opeartiontype.OperationType;

public class BigDecimalAddOperation implements OperationType {

	@Override
	public Number execute(Number num1, Number num2) {
		BigDecimal bd1 = toBigDecimal(num1);
		BigDecimal bd2 = toBigDecimal(num2);
		return bd1.add(bd2);
	}

	private BigDecimal toBigDecimal(Number number) {
		if (number instanceof BigDecimal) {
			return (BigDecimal) number;
		} else {
			return new BigDecimal(number.toString());
		}
	}
}