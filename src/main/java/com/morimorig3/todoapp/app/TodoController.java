package com.morimorig3.todoapp.app;

import com.morimorig3.todoapp.advice.ApiErrorResponse;
import com.morimorig3.todoapp.advice.NotFoundException;
import com.morimorig3.todoapp.advice.ValidationException;
import com.morimorig3.todoapp.domain.model.Todo;
import com.morimorig3.todoapp.domain.service.TodoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping
    @Operation(summary = "Todoを全件取得する")
    public List<Todo> getTodos(){
        return todoService.getTodos();
    }

    @GetMapping(path = "{id}")
    @Operation(summary = "Todoを1件取得する")
    @ApiResponses(
        {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = @Content(schema = @Schema(implementation = Todo.class))
            ),
            @ApiResponse(
                responseCode = "400",
                description = "Bad request",
                content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))
            )
        }
    )
    public Todo getTodo(@PathVariable Integer id){
        Todo todo = todoService.getTodo(id);
        if(todo == null){
            throw new NotFoundException("Todo is not found.");
        }
        return todo;
    }

    @PostMapping
    @Operation(summary = "Todoを追加する")
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(schema = @Schema(implementation = Todo.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))
                    )
            }
    )
    public Todo addTodo(
            @Validated @RequestBody Todo todo, BindingResult bindingResult
    ){
        if(bindingResult.hasErrors()){
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            throw new ValidationException(errorMessages);
        }
        todoService.addTodo(todo);
        return todo;
    }

    @PutMapping(path = "{id}")
    @Operation(summary = "Todoを更新する")
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(schema = @Schema(implementation = Todo.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))
                    )
            }
    )
    public Todo updateTodo(
            @PathVariable Integer id,
            @Validated @RequestBody Todo requestTodo,
            BindingResult bindingResult){
        // バリデーションエラー
        if(bindingResult.hasErrors()){
            String errorMessages = "";
            for (ObjectError error : bindingResult.getAllErrors()) {
                errorMessages += error.getDefaultMessage();
            }
            throw new ValidationException(errorMessages);
        }
        return todoService.updateTodo(id, requestTodo);
    }

    @DeleteMapping(path = "{id}")
    @Operation(summary = "Todoを削除する")
    @ApiResponses(
            {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(schema = @Schema(implementation = Todo.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Bad request",
                            content = @Content(schema = @Schema(implementation = ApiErrorResponse.class))
                    )
            }
    )
    public void deleteTodo(@PathVariable Integer id){
        todoService.deleteTodo(id);
    }
}
