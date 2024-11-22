package com.morimorig3.todoapp.app;

import com.morimorig3.todoapp.domain.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @GetMapping
    public List<Todo> getTodos(){
        // TODO: リスト取得処理
        List<Todo> todoList =  new ArrayList<>();
        return todoList;
    }

    @GetMapping(path = "{id}")
    public Todo getTodo(@PathVariable String id){
        // TODO: 個別取得処理
        Todo todo = new Todo();
        return todo;
    }

    @PostMapping
    public Todo addTodo(){
        // TODO: 新規追加処理
        Todo todo = new Todo();
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
