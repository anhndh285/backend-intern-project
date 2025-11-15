package com.example.asm_sof3062.exception;

public class ApiException extends RuntimeException{
    private final String code;

    public String getCode() {
        return code;
    }

    public ApiException(String message, String code) {
        super(message);
        this.code = code;
    }
}
