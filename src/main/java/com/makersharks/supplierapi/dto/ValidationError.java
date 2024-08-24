package com.makersharks.supplierapi.dto;

import java.util.List;

public class ValidationError {
    private  int errorCode;
    private List<String> message;

    public ValidationError(int errorCode, List<String> message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public List<String> getMessage() {
        return message;
    }
}
