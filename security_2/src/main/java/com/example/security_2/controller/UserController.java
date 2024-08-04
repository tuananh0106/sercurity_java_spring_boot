package com.example.security_2.controller;

import com.example.security_2.model.entity.UserInfo;
import com.example.security_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public ResponseEntity<String> addUser(@RequestBody UserInfo userInfo){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(userInfo));
    }
}
