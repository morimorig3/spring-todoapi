package com.morimorig3.todoapp.advice;

import lombok.Data;

import java.io.Serial;

@Data
public class NotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }
}
