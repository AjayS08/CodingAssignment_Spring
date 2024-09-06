package com.assignment.test.exceptionshandler;

import lombok.Data;

@Data
public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException(String message) {
        super(message);
    }
    public DivisionByZeroException(String message, Throwable cause) {
        super();
    }
    public DivisionByZeroException(Throwable cause) {
        super(String.valueOf(cause));
    }
}