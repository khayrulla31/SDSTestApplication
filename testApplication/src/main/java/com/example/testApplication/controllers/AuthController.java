package com.example.testApplication.controllers;

import com.example.testApplication.entities.Token;
import com.example.testApplication.entities.User;
import com.example.testApplication.entities.UserDTO;
import com.example.testApplication.security.JWTGenerator;
import com.example.testApplication.services.userServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth/")
public class AuthController {

    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(UserService userService, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<Token> login(@RequestBody UserDTO user) {
        User userNew = new User();
        userNew.setUsername(user.userName());
        userNew.setPassword(passwordEncoder.encode(user.password()));

        String token = jwtGenerator.generateToken(userNew.getUsername());

        return new ResponseEntity<>(new Token(token), HttpStatus.OK);
    }

    @PostMapping("registration")
    public ResponseEntity<String> register(@RequestBody UserDTO user) {

        User newby = new User();
        newby.setUsername(user.userName());
        newby.setPassword(passwordEncoder.encode(user.password()));

        userService.saveUser(newby);

        return new ResponseEntity<>("User " + newby.getUsername() + "was registered  success!", HttpStatus.OK);
    }
}
