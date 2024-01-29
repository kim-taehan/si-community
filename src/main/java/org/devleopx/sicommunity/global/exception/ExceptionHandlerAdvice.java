package org.devleopx.sicommunity.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<?> illegalArgumentException(IllegalArgumentException e) {
        final ErrorResponse errorResponse = ErrorResponse.create(e, HttpStatus.BAD_REQUEST, "");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
