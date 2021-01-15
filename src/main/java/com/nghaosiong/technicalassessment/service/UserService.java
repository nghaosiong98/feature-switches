package com.nghaosiong.technicalassessment.service;

import com.nghaosiong.technicalassessment.model.entity.User;
import com.nghaosiong.technicalassessment.model.exception.UserNotFoundException;
import com.nghaosiong.technicalassessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).orElseThrow(() ->
                new UserNotFoundException(email));
    }
}
