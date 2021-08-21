package com.api.todo.service;

import java.util.List;

import com.api.todo.DTO.TodoDTO;
import com.api.todo.entity.Todo;

public interface TodoService {
    
    // CREATE

    TodoDTO addTodo(Todo todo, long workSpaceId);

    // READ
    
    List<TodoDTO> getTodos(long id);
    
    // UPDATE

    TodoDTO updateTodo(long id, Todo todo);

    // DELETE

    void deleteTodo(long id);


}
