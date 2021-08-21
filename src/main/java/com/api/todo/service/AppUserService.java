package com.api.todo.service;

import com.api.todo.entity.User;

public interface AppUserService {
    
    // CREATE

    User addUser(User user);

    // READ

    User getUser(String username);

    // DELETE

    void deleteUser(long id);

}
