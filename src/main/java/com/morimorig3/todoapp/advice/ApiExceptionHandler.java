package com.morimorig3.todoapp.advice;

import com.morimorig3.todoapp.advice.ApiError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, Object body, HttpHeaders headers,
            HttpStatusCode status, WebRequest request) {
        ApiError apiError = new ApiError(status, ex.getMessage());
        return super.handleExceptionInternal(
                ex,apiError,headers,status,request
        );
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(
            NotFoundException ex, WebRequest request) {
        HttpStatusCode status = HttpStatus.NOT_FOUND;
        ApiError apiError = new ApiError(status, ex.getMessage());
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Object> handleNotFoundException(
            ValidationException ex, WebRequest request) {
        HttpStatusCode status = HttpStatus.BAD_REQUEST;
        ApiError apiError = new ApiError(status, ex.getMessage());
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), status, request);
    }
}
