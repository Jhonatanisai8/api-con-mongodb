package com.isai.api_mongodb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isai.api_mongodb.models.dto.UserDto;
import com.isai.api_mongodb.service.serviceImpl.UserServiceImple;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserServiceImple userServiceImple;

    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        userServiceImple.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User saved successfully");
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> findAllUsers() {
        return ResponseEntity.ok(userServiceImple.findAllUsers());
    }

}
