package com.rf.labrex.errorManagement;

import com.rf.labrex.exception.HospitalNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> validationErrorHandler(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ApiResponse apiError = new ApiResponse();
        Map<String, String> errors = new HashMap<>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        apiError = ApiResponse.builder().dateTime(apiError.getDateTime()).errors(errors).message("validation Error").status(400).path(request.getRequestURI()).build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
    @ExceptionHandler(HospitalNotFoundException.class)
    public ResponseEntity<ApiResponse> NotFoundException(RuntimeException ex,HttpServletRequest request){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse=ApiResponse.builder().path(request.getRequestURI()).message(ex.getMessage()).status(404).dateTime(apiResponse.getDateTime()).build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiResponse);
    }


}
