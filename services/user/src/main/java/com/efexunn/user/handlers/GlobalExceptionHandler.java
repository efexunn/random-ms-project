package com.efexunn.user.handlers;

import com.efexunn.user.exceptions.UserAlreadyExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public ResponseEntity<Map<String, String>> handleUserAlreadyExistException(UserAlreadyExistException exception){
        log.warn("User already exist with this email {}", exception.getMessage());
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "User already exists");
        return ResponseEntity.badRequest().body(errors);
    }
}
