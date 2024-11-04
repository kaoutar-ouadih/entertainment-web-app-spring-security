package com.example.entertainment_web_app_backend.Controller;

import com.example.entertainment_web_app_backend.Model.Users;
import com.example.entertainment_web_app_backend.Service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Usercontroller {
    private final UserService userService;

    public Usercontroller(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Users user){
        return this.userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }

}
