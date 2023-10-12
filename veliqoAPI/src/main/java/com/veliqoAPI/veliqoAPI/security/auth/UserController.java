package com.veliqoAPI.veliqoAPI.security.auth;

import com.veliqoAPI.veliqoAPI.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/profile/{email}")
   // @CrossOrigin(origins= "http://localhost:4200", allowedHeaders = "Content-Type': 'application/json")
    public Optional<User> user(@PathVariable String email){
        return userService.userProfile(email);
    }
}
