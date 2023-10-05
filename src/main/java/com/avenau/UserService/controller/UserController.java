package com.avenau.UserService.controller;

import com.avenau.UserService.models.User;
import com.avenau.UserService.models.UserResponse;
import com.avenau.UserService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void registerUser(@RequestBody UserResponse userResponse){
        User user = new User();
        userService.save(user);
    }

    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    public void removeUser(@RequestBody UserResponse userResponse){
        User user = new User();
        userService.remove(user);
    }



}
