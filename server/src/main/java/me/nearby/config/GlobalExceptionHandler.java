package me.nearby.config;

import lombok.extern.slf4j.Slf4j;
import me.nearby.domain.geometry.usecase.exception.InvalidRadiusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        log.error("An error occurred", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown error");
    }

    @ExceptionHandler(InvalidRadiusException.class)
    public ResponseEntity<String> handleInvalidRadiusException(InvalidRadiusException e) {
        log.error("Invalid radius", e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid radius value");
    }
}
