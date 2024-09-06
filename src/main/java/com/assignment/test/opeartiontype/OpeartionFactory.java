package com.assignment.test.opeartiontype;

import java.math.BigDecimal;
import com.assignment.test.enums.Operation;
import com.assignment.test.opeartiontype.addition.BigDecimalAddOperation;
import com.assignment.test.opeartiontype.addition.DoubleAddOperation;
import com.assignment.test.opeartiontype.addition.IntegerAddOperation;
import com.assignment.test.opeartiontype.division.BigDecimalDivideOperation;
import com.assignment.test.opeartiontype.division.DoubleDivideOperation;
import com.assignment.test.opeartiontype.division.IntegerDivideOperation;
import com.assignment.test.opeartiontype.multiply.BigDecimalMultiplyOperation;
import com.assignment.test.opeartiontype.multiply.DoubleMultiplyOperation;
import com.assignment.test.opeartiontype.multiply.IntegerMultiplyOperation;
import com.assignment.test.opeartiontype.subtraction.BigDecimalSubtractOperation;
import com.assignment.test.opeartiontype.subtraction.DoubleSubtractOperation;
import com.assignment.test.opeartiontype.subtraction.IntegerSubtractOperation;

public class OpeartionFactory {

	public static OperationType getStrategy(Operation operation, Number number1, Number number2) {
		if (operation == Operation.ADD) {
			if (number1 instanceof BigDecimal || number2 instanceof BigDecimal) {
				return new BigDecimalAddOperation();
			} else if (number1 instanceof Double || number2 instanceof Double) {
				return new DoubleAddOperation();
			} else if (number1 instanceof Integer && number2 instanceof Integer) {
				return new IntegerAddOperation();
			}
		} else if (operation == Operation.SUBTRACT) {
			if (number1 instanceof BigDecimal || number2 instanceof BigDecimal) {
				return new BigDecimalSubtractOperation();
			} else if (number1 instanceof Double || number2 instanceof Double) {
				return new DoubleSubtractOperation();
			} else if (number1 instanceof Integer && number2 instanceof Integer) {
				return new IntegerSubtractOperation();
			}
		} else if (operation == Operation.MULTIPLY) {
			if (number1 instanceof BigDecimal || number2 instanceof BigDecimal) {
				return new BigDecimalMultiplyOperation();
			} else if (number1 instanceof Double || number2 instanceof Double) {
				return new DoubleMultiplyOperation();
			} else if (number1 instanceof Integer && number2 instanceof Integer) {
				return new IntegerMultiplyOperation();
			}
		} else if (operation == Operation.DIVIDE) {
			if (number1 instanceof BigDecimal || number2 instanceof BigDecimal) {
				return new BigDecimalDivideOperation();
			} else if (number1 instanceof Double || number2 instanceof Double) {
				return new DoubleDivideOperation();
			} else if (number1 instanceof Integer && number2 instanceof Integer) {
				return new IntegerDivideOperation();
			}
		}

		throw new UnsupportedOperationException("Unsupported operation or number type");
	}
}