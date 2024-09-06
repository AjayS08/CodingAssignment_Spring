package com.assignment.test.exceptionshandler;

import lombok.Data;

@Data
public class UnsupportedOperationException extends RuntimeException {
    public UnsupportedOperationException(String message) {
        super(message);
    }
    public UnsupportedOperationException(String message, Throwable cause) {
        super();
    }
    public UnsupportedOperationException(Throwable cause) {
        super(String.valueOf(cause));
    }
}
