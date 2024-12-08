package com.snzn.project.order.service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
        log.error("Unexpected error!", ex);
        return new ResponseEntity<>("Unexpected error!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(PaymentFailedException.class)
    public ResponseEntity<Object> handlePaymentFailedException(PaymentFailedException ex, WebRequest request) {
        log.error("Payment Failed!", ex);
        return new ResponseEntity<>("Payment Failed!", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
