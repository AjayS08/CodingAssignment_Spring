package com.assignment.test.datamodel;

import lombok.Data;

@Data
public class CalculateRequest {
	private String opeartion;
	private Number number1;
	private Number number2;
}
