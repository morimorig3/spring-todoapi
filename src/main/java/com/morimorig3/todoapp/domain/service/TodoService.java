package com.morimorig3.todoapp.domain.service;

import com.morimorig3.todoapp.advice.NotFoundException;
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
    public Todo getTodo(Integer id){
        Todo todo = todoRepository.findById(id).orElse(null);
        if(todo == null){
            throw new NotFoundException("Todo is not found.");
        }
        return todo;
    }

    @Transactional
    public Todo addTodo(Todo todo){
        todoRepository.save(todo);
        return todo;
    }


    @Transactional
    public Todo updateTodo(Integer id,Todo todo){
        if(!todoRepository.existsById(id)){
            throw new NotFoundException("Todo is not found.");
        }
        todo.setId(id);
        todoRepository.save(todo);
        return todo;
    }

    @Transactional
    public void deleteTodo(Integer id){
        if(!todoRepository.existsById(id)){
            throw new NotFoundException("Todo is not found.");
        }
        todoRepository.deleteById(id);
    }
}
