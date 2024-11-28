package com.morimorig3.todoapp.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.Locale;

@Entity
@Data
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Input contents are empty.")
    private String text;

    public Todo(){}

    public Todo(String text){
        this.text = text;
    }
}
