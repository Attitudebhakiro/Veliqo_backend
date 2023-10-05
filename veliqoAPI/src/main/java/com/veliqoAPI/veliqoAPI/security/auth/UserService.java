package com.veliqoAPI.veliqoAPI.security.auth;

import com.veliqoAPI.veliqoAPI.security.user.User;
import com.veliqoAPI.veliqoAPI.security.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public Optional<User> userProfile(String email){
        return repository.findByEmail(email);
    }
}
