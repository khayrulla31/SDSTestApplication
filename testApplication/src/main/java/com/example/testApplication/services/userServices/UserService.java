package com.example.testApplication.services.userServices;

import com.example.testApplication.entities.User;

public interface UserService {
    User saveUser(User user);
    User findByUserName(String userName);
}
