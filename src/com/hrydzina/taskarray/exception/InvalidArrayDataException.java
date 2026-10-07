package com.hrydzina.taskarray.exception;

public class InvalidArrayDataException extends Exception {

    public InvalidArrayDataException(String message) {
        super(message);
    }
    public InvalidArrayDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
