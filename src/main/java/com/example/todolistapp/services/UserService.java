package com.example.todolistapp.services;

import com.example.todolistapp.dtos.request.CreateUserRequest;
import com.example.todolistapp.dtos.request.LoginRequest;
import com.example.todolistapp.dtos.request.UserUpdateRequest;
import com.example.todolistapp.dtos.response.CreateUserResponse;
import com.example.todolistapp.dtos.response.GetResponse;
import com.example.todolistapp.dtos.response.LoginResponse;

public interface UserService {
    CreateUserResponse createUser(CreateUserRequest createUserRequest);
    LoginResponse userLogin(LoginRequest loginRequest);
    GetResponse updateUser(UserUpdateRequest userUpdateRequest);
    GetResponse deleteUser(String id);
}
