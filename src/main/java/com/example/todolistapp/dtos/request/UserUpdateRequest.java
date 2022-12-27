package com.example.todolistapp.dtos.request;

import lombok.Data;

@Data
public class UserUpdateRequest {
    private String id;
    private String phoneNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
