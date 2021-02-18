package com.revature.web.exceptions;

public class IllegalRequestException extends RuntimeException {

    public IllegalRequestException(String message) {
        super(message);
    }

}
