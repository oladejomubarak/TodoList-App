package com.example.todolistapp.services;

import com.example.todolistapp.dtos.request.CreateTodoRequest;
import com.example.todolistapp.dtos.request.TodoUpdateRequest;
import com.example.todolistapp.dtos.response.CreateTodoResponse;
import com.example.todolistapp.dtos.response.GetResponse;
import com.example.todolistapp.dtos.response.TodoUpdateResponse;

import java.time.LocalDateTime;

public interface TodoServices {
    CreateTodoResponse createTodo(CreateTodoRequest createTodoRequest);
    GetResponse updateTodo(TodoUpdateRequest todoUpdateRequest);
    GetResponse viewTodoById(int id);
    GetResponse viewTodoByDate(LocalDateTime dateAndTime);
    GetResponse deleteTodo(int id);
    GetResponse clearTodo();
}
