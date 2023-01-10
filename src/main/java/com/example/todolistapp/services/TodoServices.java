package com.example.todolistapp.services;

import com.example.todolistapp.data.models.Todo;
import com.example.todolistapp.dtos.request.CreateTodoRequest;
import com.example.todolistapp.dtos.request.TodoUpdateRequest;
import com.example.todolistapp.dtos.response.CreateTodoResponse;
import com.example.todolistapp.dtos.response.GetResponse;
import com.example.todolistapp.dtos.response.TodoUpdateResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoServices {
    CreateTodoResponse createTodo(CreateTodoRequest createTodoRequest);
    GetResponse updateTodo(TodoUpdateRequest todoUpdateRequest);
    Todo viewTodoById(String id);
//    List<Todo> viewTodoByDate(String date);
    GetResponse deleteTodo(String id);
    GetResponse clearTodo();
}
