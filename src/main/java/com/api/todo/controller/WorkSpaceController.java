package com.api.todo.controller;

import java.security.Principal;

import com.api.todo.DTO.WorkSpaceDTO;
import com.api.todo.entity.User;
import com.api.todo.entity.WorkSpace;
import com.api.todo.service.AppUserService;
import com.api.todo.service.WorkSpaceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/workspaces")
public class WorkSpaceController {
    
    @Autowired
    private WorkSpaceService workSpaceService;

    @Autowired
    private AppUserService userService;

    @GetMapping("")
    public ResponseEntity<?> getWorkSpaces(Principal principal) {
        String username = principal.getName();
        return ResponseEntity.ok().body(workSpaceService.getWorkSpaces(username)); 
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<?> getWorkSpace(@PathVariable long id) {
    //     return ResponseEntity.ok().body(workSpaceService.getWorkSpace(id));
    // }

    @PostMapping("")
    public ResponseEntity<?> addWorkSpace(Principal principal, @RequestBody WorkSpace workSpace) {
        User user = userService.getUser(principal.getName());
        WorkSpaceDTO workSpaceDTO = workSpaceService.addWorkSpace(workSpace, user);
        return new ResponseEntity<>(workSpaceDTO ,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateWorkSpace(@PathVariable long id, @RequestBody WorkSpace workSpace) {
        WorkSpaceDTO workSpaceUpdated = workSpaceService.updateWorkSpace(id, workSpace);
        return new ResponseEntity<>(workSpaceUpdated ,HttpStatus.OK);
    }

    // @PutMapping("/{workSpaceId}/users/{userId}")
    // public ResponseEntity<?> updateWorkSpaceAddUser(@PathVariable long workSpaceId, @PathVariable long userId) {
    //     WorkSpaceDTO workSpace = workSpaceService.updateWorkSpaceAddUser(workSpaceId, userId);
    //     return new ResponseEntity<>(workSpace ,HttpStatus.OK);
    // }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteWorkSpace(@PathVariable long id) {
        workSpaceService.deleteWorkSpace(id);
        return ResponseEntity.ok().build();
    }

}
