package com.scaler.ecommerceEngine.advices;

import com.scaler.ecommerceEngine.dtos.ErrorResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleExceptions(RuntimeException e) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setStatus("ERROR");
        dto.setMessage(e.getMessage());
        return dto;
    }
}
