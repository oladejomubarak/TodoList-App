package com.example.todolistapp.dtos.response;

import lombok.Data;

@Data
public class CreateTodoResponse {
    private String id;
    private String statusCode;
    private String message;
}
