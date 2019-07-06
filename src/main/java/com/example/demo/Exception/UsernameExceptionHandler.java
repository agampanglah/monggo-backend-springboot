package com.example.demo.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class UsernameExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameAlreadyExist(UsernameAlreadyExistException ex, WebRequest request) {
        UsernameAlreadyExist exist = new UsernameAlreadyExist(ex.getMessage());
        return new ResponseEntity(exist, HttpStatus.BAD_REQUEST);

    }
}
