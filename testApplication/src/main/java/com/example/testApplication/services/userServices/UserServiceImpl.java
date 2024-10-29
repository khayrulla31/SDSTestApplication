package com.example.testApplication.services.userServices;

import com.example.testApplication.entities.User;
import com.example.testApplication.exception.UnavailableNameException;
import com.example.testApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        Optional<User> checkIfExist = userRepository.findByUsernameIgnoreCase(user.getUsername());
        if (checkIfExist.isPresent()) {
            throw new UnavailableNameException("This name is already taken!");
        }
        return userRepository.save(user);
    }

    public User findByUserName(String userName) {
        Optional<User> checkIfExist = userRepository.findByUsernameIgnoreCase(userName);
        if (checkIfExist.isPresent()) {
            throw new UnavailableNameException(" имя занято!");
        }
        User newUser = checkIfExist.get();

        return newUser;
    }
}
