package com.api.todo.service;

import java.util.List;

import com.api.todo.DTO.WorkSpaceDTO;
import com.api.todo.entity.User;
import com.api.todo.entity.WorkSpace;

public interface WorkSpaceService {
    
    List<WorkSpaceDTO> getWorkSpaces(String username);

    WorkSpaceDTO getWorkSpace(long id);

    WorkSpaceDTO addWorkSpace(WorkSpace workSpace, User user);

    WorkSpaceDTO updateWorkSpace(long id, WorkSpace workSpace);

    // WorkSpaceDTO updateWorkSpaceAddUser(long workSpaceId, long userId);

    void deleteWorkSpace(long id);

}
