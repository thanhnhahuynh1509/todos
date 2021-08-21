package com.api.todo.service;

import com.api.todo.entity.User;
import com.api.todo.exception.UserExistsException;
import com.api.todo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements AppUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User addUser(User user) {
        user.setRole("USER");
        boolean checkUserExists = userRepository.findByUsername(user.getUsername()).isPresent();
        
        if(checkUserExists) {
            throw new UserExistsException("User đã tồn tại");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return user;
        }
    }

    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
    
}
