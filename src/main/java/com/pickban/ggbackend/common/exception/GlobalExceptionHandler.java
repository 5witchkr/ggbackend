package com.pickban.ggbackend.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NullPointerException.class)
    protected ResponseEntity<Object> nullPoint(NullPointerException nullPointerException) {
        log.error("throw NullPointException : {}", nullPointerException.getMessage());
        return new ResponseEntity<>(nullPointerException.getMessage(), HttpStatus.NOT_FOUND);
    }
}
