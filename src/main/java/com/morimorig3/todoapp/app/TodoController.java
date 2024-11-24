package com.morimorig3.todoapp.app;

import com.morimorig3.todoapp.domain.model.Todo;
import com.morimorig3.todoapp.domain.repository.TodoRepository;
import com.morimorig3.todoapp.domain.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @GetMapping(path = "{id}")
    public Todo getTodo(@PathVariable Integer id){
        return todoService.getTodoById(id);
    }

    @PostMapping
    public Todo addTodo(
            @Validated @RequestBody Todo todo, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            System.out.println("hasErrors");
        }
        todoService.addTodo(todo);
        return todo;
    }

    @PutMapping(path = "{id}")
    public Todo updateTodo(){
        // TODO: 更新処理
        Todo todo = new Todo();
        return todo;
    }

    @DeleteMapping(path = "{id}")
    public Void deleteTodo(){
        // TODO: 削除処理
        return null;
    }
}
