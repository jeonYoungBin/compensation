package com.compensation.compensation.exception;

import com.compensation.compensation.domain.response.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvisorController {

    @ExceptionHandler(CustomExcepiton.class)
    Response processExceptionError(CustomExcepiton e) {
        return new Response(206, e.getMessage(), null);
    }
}
