package com.example.testApplication.services.userServices;

import com.example.testApplication.entities.User;
import com.example.testApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> checkIfExist = userRepository.findByUsernameIgnoreCase(userName);
        if(checkIfExist.isEmpty()){
            throw new UsernameNotFoundException("User "+userName+" doesn't exist!",null);
        }
        User user = checkIfExist.get();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
    }


}
