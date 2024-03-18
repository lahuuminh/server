package com.minhhuu.banhang.exceptionhandler;

import com.minhhuu.banhang.model.Message;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Message> handleEmptyResultDataAccessException(EmptyResultDataAccessException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new Message("Không tìm thấy dữ liệu."));
    }
   @ExceptionHandler(Exception.class)
   public ResponseEntity<Message> handleGenericException(Exception e) {
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body(new Message(e.getMessage()));
   }
}
