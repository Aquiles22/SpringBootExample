package com.pagatodo.test.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomLoginException extends Exception {

    private String code;
    private HttpStatus status;

    public CustomLoginException(String message, String code, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }

}
