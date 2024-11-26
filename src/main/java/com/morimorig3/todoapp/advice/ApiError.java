package com.morimorig3.todoapp.advice;

import org.springframework.http.HttpStatusCode;

import java.io.Serial;
import java.io.Serializable;

public class ApiError implements Serializable {

    private static class Error implements Serializable{
        @Serial
        private static final long serialVersionUID = 1L;

        private HttpStatusCode statusCode;
        private String message;

        public HttpStatusCode getStatusCode() {
            return statusCode;
        }
        public String getMessage() {
            return message;
        }
        public void setStatusCode(HttpStatusCode statusCode) {
            this.statusCode = statusCode;
        }
        public void setMessage(String message) {
            this.message = message;
        }
    }
    private Error error;

    public Error getError() {
        return error;
    }

    public ApiError(HttpStatusCode statusCode, String message){
        this.error = new Error();
        this.error.setStatusCode(statusCode);
        this.error.setMessage(message);
    }
}
