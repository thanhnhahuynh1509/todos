package com.api.todo.controller;

import com.api.todo.DTO.TodoDTO;
import com.api.todo.entity.Todo;
import com.api.todo.service.TodoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    @GetMapping("/workspaces/{workSpaceId}")
    public ResponseEntity<?> getTodos(@PathVariable long workSpaceId) {
        return ResponseEntity.ok().body(todoService.getTodos(workSpaceId));
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> getTodo(@PathVariable long id) {
    //     return ResponseEntity.ok().body(todoService.getTodo(id));
    // }

    @PostMapping("/workspaces/{workSpaceId}")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo, @PathVariable long workSpaceId) {
        TodoDTO todoDTO = todoService.addTodo(todo, workSpaceId);
        return new ResponseEntity<>(todoDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable long id,@RequestBody Todo todo) {
        TodoDTO todoUpdated = todoService.updateTodo(id, todo);
        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    // @PutMapping("/{todoId}/workspaces/{workSpaceId}")
    // public ResponseEntity<?> updateTodoAddWorkSpace(@PathVariable long todoId, @PathVariable long workSpaceId) {
    //     TodoDTO todo = todoService.updateTodoAddWorkSpace(todoId, workSpaceId);
    //     return new ResponseEntity<>(todo, HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

}
