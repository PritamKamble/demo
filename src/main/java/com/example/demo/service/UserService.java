package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User updateUser(User newUser) throws ResourceNotFoundException {
        User user = userRepository.findById(newUser.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        userRepository.save(user);
        return user;
    }

    public Map<String, Boolean> deleteUserById(Long id) throws ResourceNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userRepository.delete(user);

        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("deleted", Boolean.TRUE);
        return map;
    }
}
