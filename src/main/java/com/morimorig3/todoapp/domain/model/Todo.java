package com.morimorig3.todoapp.domain.model;

import java.io.Serializable;

public class Todo implements Serializable {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
