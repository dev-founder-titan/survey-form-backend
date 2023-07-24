package com.survey.form.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleException(Exception exception) {
        String message = exception.getMessage();
        Map<String,String> err = new HashMap<>();
        err.put("message",message);
        err.put("errorCode",String.valueOf(400));
        err.put("reasonPhrase",HttpStatus.BAD_REQUEST.getReasonPhrase());
        return err;
    }
}
