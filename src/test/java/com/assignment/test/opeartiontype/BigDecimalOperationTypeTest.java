package com.assignment.test.opeartiontype;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import com.assignment.test.opeartiontype.addition.BigDecimalAddOperation;
import com.assignment.test.opeartiontype.subtraction.BigDecimalSubtractOperation;
import com.assignment.test.opeartiontype.multiply.BigDecimalMultiplyOperation;
import com.assignment.test.opeartiontype.division.BigDecimalDivideOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BigDecimalOperationTypeTest {

	private OperationType addOperation;
	private OperationType subtractOperation;
	private OperationType multiplyOperation;
	private OperationType divideOperation;

	@BeforeEach
	public void setUp() {
		addOperation = new BigDecimalAddOperation();
		subtractOperation = new BigDecimalSubtractOperation();
		multiplyOperation = new BigDecimalMultiplyOperation();
		divideOperation = new BigDecimalDivideOperation();
	}

	@Test
	public void testAddOperation() {
		// Very large numbers
		BigDecimal bd1 = new BigDecimal("1000000000000000000000");
		BigDecimal bd2 = new BigDecimal("2000000000000000000000");
		assertEquals(new BigDecimal("3000000000000000000000"), addOperation.execute(bd1, bd2));

		// Zero and Negative values
		assertEquals(new BigDecimal("100"), addOperation.execute(new BigDecimal("100"), BigDecimal.ZERO));
		assertEquals(new BigDecimal("-100"), addOperation.execute(new BigDecimal("-200"), new BigDecimal("100")));

		// Very small numbers
		BigDecimal small1 = new BigDecimal("0.00000000000000001");
		BigDecimal small2 = new BigDecimal("0.00000000000000002");
		assertEquals(new BigDecimal("0.00000000000000003"), addOperation.execute(small1, small2));
	}

	@Test
	public void testSubtractOperation() {
		// Very large numbers
		BigDecimal bd1 = new BigDecimal("1000000000000000000000");
		BigDecimal bd2 = new BigDecimal("2000000000000000000000");
		assertEquals(new BigDecimal("-1000000000000000000000"), subtractOperation.execute(bd1, bd2));

		// Zero and Negative values
		assertEquals(new BigDecimal("100"), subtractOperation.execute(new BigDecimal("100"), BigDecimal.ZERO));
		assertEquals(new BigDecimal("-300"), subtractOperation.execute(new BigDecimal("-200"), new BigDecimal("100")));

		// Very small numbers
		BigDecimal small1 = new BigDecimal("0.00000000000000001");
		BigDecimal small2 = new BigDecimal("0.00000000000000002");
		assertEquals(new BigDecimal("-0.00000000000000001"), subtractOperation.execute(small1, small2));
	}

	@Test
	public void testMultiplyOperation() {
		// Very large numbers
		BigDecimal bd1 = new BigDecimal("1000000000000000000000");
		BigDecimal bd2 = new BigDecimal("2000000000000000000000");
		assertEquals(new BigDecimal("2000000000000000000000000000000000000000"), multiplyOperation.execute(bd1, bd2));

		// Zero and Negative values
		assertEquals(BigDecimal.ZERO, multiplyOperation.execute(new BigDecimal("100"), BigDecimal.ZERO));
		assertEquals(new BigDecimal("-20000"), multiplyOperation.execute(new BigDecimal("-200"), new BigDecimal("100")));

		// Very small numbers
		BigDecimal small1 = new BigDecimal("0.00000000000000001");
		BigDecimal small2 = new BigDecimal("1000000000000000000000");
		assertEquals(new BigDecimal("0.00000000000001"), multiplyOperation.execute(small1, small2));
	}

	@Test
	public void testDivideOperation() {
		// Very large numbers
		BigDecimal bd1 = new BigDecimal("1000000000000000000000");
		BigDecimal bd2 = new BigDecimal("2000000000000000000000");
		BigDecimal expected = BigDecimal.valueOf(0.5).setScale(BigDecimalDivideOperation.SCALE, RoundingMode.HALF_UP);
		assertEquals(expected, divideOperation.execute(bd1, bd2));

		// Small numbers
		BigDecimal small1 = new BigDecimal("0.00000000000000001");
		BigDecimal small2 = new BigDecimal("0.00000000000000002");
		expected = new BigDecimal("0.5").setScale(BigDecimalDivideOperation.SCALE, RoundingMode.HALF_UP);
		assertEquals(expected, divideOperation.execute(small1, small2));

		// Test division by zero
		BigDecimal bdZero = BigDecimal.ZERO;
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			divideOperation.execute(bd1, bdZero);
		});
		assertTrue(exception.getMessage().contains("Division by zero"));

		// Negative values
		assertEquals(new BigDecimal("-1.0").setScale(BigDecimalDivideOperation.SCALE, RoundingMode.HALF_UP),
				divideOperation.execute(new BigDecimal("-100"), new BigDecimal("100")));
	}
}
