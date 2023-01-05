package com.example.todolistapp.data.controller;

import com.example.todolistapp.dtos.request.CreateUserRequest;
import com.example.todolistapp.dtos.request.LoginRequest;
import com.example.todolistapp.dtos.request.UserUpdateRequest;
import com.example.todolistapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody CreateUserRequest createUserRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUserRequest));
    }

    @GetMapping("/userlogin")
    public ResponseEntity<?> userLogin(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userService.userLogin(loginRequest));
    }
    @PatchMapping("/updateuser")
    public ResponseEntity<?> updateUser(@RequestBody UserUpdateRequest userUpdateRequest){
        return ResponseEntity.ok(userService.updateUser(userUpdateRequest));
    }
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }
}
