package com.api.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.api.todo.DTO.TodoDTO;
import com.api.todo.DTO.TransferDTO;
import com.api.todo.entity.Todo;
import com.api.todo.entity.WorkSpace;
import com.api.todo.exception.NotFoundException;
import com.api.todo.repository.TodoRepository;
import com.api.todo.repository.WorkSpaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private WorkSpaceRepository workSpaceRepository;

    @Autowired
    private TransferDTO transferDTO;

    @Override
    public TodoDTO addTodo(Todo todo, long workSpaceId) {
        WorkSpace workSpace = workSpaceRepository.findById(workSpaceId).get();
        todo.setWorkSpace(workSpace);
        todoRepository.save(todo);
        TodoDTO todoDTO = transferDTO.todoTransferDTO(todo);
        return todoDTO;
    }

    @Override
    public List<TodoDTO> getTodos(long id) {
        List<Todo> todos = todoRepository.findAllTodosByWorkSpaceId(id);
        List<TodoDTO> todoDTOs = new ArrayList<>();
        
        for(Todo todo : todos) {
            todoDTOs.add(transferDTO.todoTransferDTO(todo));
        }

        return todoDTOs;
    }

    @Override
    public TodoDTO updateTodo(long id, Todo todo) {
        boolean checkTodoExists = todoRepository.findById(id).isPresent();

        if(!checkTodoExists) {
            throw new NotFoundException("Không tìm thấy todo có id: " + id);
        } else {
            Todo todoCurrent = todoRepository.findById(id).get();
            todoCurrent.setStatus(todo.isStatus());
            todoCurrent.setDate(todo.getDate());
            todoCurrent.setContent(todo.getContent());
            todoRepository.save(todoCurrent);
            return transferDTO.todoTransferDTO(todoCurrent);
        }
    }

    @Override
    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }

}
