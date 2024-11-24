package com.morimorig3.todoapp.domain.service;

import com.morimorig3.todoapp.domain.model.Todo;
import com.morimorig3.todoapp.domain.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TodoService {
    @Autowired
    TodoRepository todoRepository;

    @Transactional
    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    @Transactional
    public Todo getTodoById(Integer id){
        Todo todo = todoRepository.findById(id).orElse(null);
        if(todo == null){
            System.out.println("error handling");
        }
        return todo;
    }

    @Transactional
    public Todo addTodo(Todo todo){
        todoRepository.save(todo);
        return todo;
    }
}
