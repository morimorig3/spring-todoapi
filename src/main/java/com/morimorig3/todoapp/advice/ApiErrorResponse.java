package com.morimorig3.todoapp.advice;

import org.springframework.http.HttpStatusCode;

import java.io.Serial;
import java.io.Serializable;

public class ApiErrorResponse implements Serializable {

    private static class Error implements Serializable{
        @Serial
        private static final long serialVersionUID = 1L;

        private Integer statusCode;
        private String message;

        public Integer getStatusCode() {
            return statusCode;
        }
        public String getMessage() {
            return message;
        }
        public void setStatusCode(HttpStatusCode statusCode) {
            this.statusCode = statusCode.value();
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }
    private Error error;

    public Error getError() {
        return error;
    }

    public ApiErrorResponse(HttpStatusCode statusCode, String message){
        this.error = new Error();
        this.error.setStatusCode(statusCode);
        this.error.setMessage(message);
    }
}
