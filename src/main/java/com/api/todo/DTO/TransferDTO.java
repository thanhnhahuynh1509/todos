package com.api.todo.DTO;

import com.api.todo.entity.Todo;
import com.api.todo.entity.WorkSpace;

import org.springframework.stereotype.Component;

@Component
public class TransferDTO {
    
    public TodoDTO todoTransferDTO(Todo todo) {
        TodoDTO todoDTO = new TodoDTO(todo.getTodoId(), todo.getContent(), todo.getDate(), todo.isStatus(), todo.getWorkSpace().getWkId());
        return todoDTO;
    }

    public WorkSpaceDTO workSpaceTransferDTO(WorkSpace workSpace) {
        WorkSpaceDTO workSpaceDTO = new WorkSpaceDTO(workSpace.getWkId(), workSpace.getName(), workSpace.getUser().getUserId());
        return workSpaceDTO;
    }

}
