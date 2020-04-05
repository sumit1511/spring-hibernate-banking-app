package com.bank.exceptions.handler;

import com.bank.exceptions.custom.CustomException;
import com.bank.exceptions.model.CustomExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CustomExceptionResponse> handleBranchException(CustomException customException)
    {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse();
        customExceptionResponse.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        customExceptionResponse.setMassage(customException.getMessage());
        customExceptionResponse.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        return new ResponseEntity<>(customExceptionResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<CustomExceptionResponse> handleBranchExceptions(Exception exception)
    {
        CustomExceptionResponse customExceptionResponse = new CustomExceptionResponse();
        customExceptionResponse.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        customExceptionResponse.setMassage(exception.getMessage());
        customExceptionResponse.setTimeStamp(String.valueOf(System.currentTimeMillis()));
        return new ResponseEntity<>(customExceptionResponse,HttpStatus.NOT_FOUND);
    }
}
