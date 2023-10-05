package com.charter.reward.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    
    @Value(value = "${data.exception.customernotfound}")
    private String customernotfound;
    @Value(value = "${data.exception.datalost}")
    private String datalost;
    
    @ExceptionHandler(value = CustomerNotFoundException.class)
    public ResponseEntity customerNotFoundException(CustomerNotFoundException blogNotFoundException) {
        return new ResponseEntity(customernotfound, HttpStatus.NOT_FOUND);
    }
   @ExceptionHandler(value = Exception.class)
    public ResponseEntity databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity(datalost, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
