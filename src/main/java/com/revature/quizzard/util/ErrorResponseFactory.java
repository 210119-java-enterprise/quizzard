package com.revature.quizzard.util;

import com.revature.quizzard.dtos.ErrorResponse;
import com.revature.quizzard.dtos.QuizzardHttpStatus;

public class ErrorResponseFactory {

    private static ErrorResponseFactory errRespFactory = new ErrorResponseFactory();

    private ErrorResponseFactory() {
        super();
    }

    public static ErrorResponseFactory getInstance() {
        return errRespFactory;
    }

    public ErrorResponse generateErrorResponse(int status, String message) {
        return new ErrorResponse(status, message, System.currentTimeMillis());
    }

    public ErrorResponse generateErrorResponse(QuizzardHttpStatus status) {
        return new ErrorResponse(status.getStatus(), status.toString(), System.currentTimeMillis());
    }

}
