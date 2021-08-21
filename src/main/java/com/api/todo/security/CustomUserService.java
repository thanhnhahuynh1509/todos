package com.api.todo.security;

import java.util.Optional;

import com.api.todo.entity.User;
import com.api.todo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if(!user.isPresent()) {
            throw new UsernameNotFoundException("Username or password invalid");
        } else {
            UserDetails userDetails = org.springframework.security.core.userdetails.User
                                        .builder()
                                        .username(user.get().getUsername())
                                        .password(user.get().getPassword())
                                        .roles(user.get().getRole())
                                        .build();
            return userDetails;
        }
    }
    
}
