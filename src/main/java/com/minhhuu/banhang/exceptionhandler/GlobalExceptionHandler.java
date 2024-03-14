package com.minhhuu.banhang.exceptionhandler;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<String> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Không tìm thấy dữ liệu.");
    }
   @ExceptionHandler(Exception.class)
   public ResponseEntity<String> handleGenericException(Exception e) {
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body(e.getMessage());
   }
}
