package com.example.todolistapp.data.controller;

import com.example.todolistapp.dtos.request.CreateTodoRequest;
import com.example.todolistapp.dtos.request.TodoUpdateRequest;
import com.example.todolistapp.services.TodoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TodoController {

    @Autowired
    private TodoServices todoServices;
    @PostMapping("/todo")
    public ResponseEntity<?> createTodo(@RequestBody CreateTodoRequest createTodoRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoServices.createTodo(createTodoRequest));
    }
    @PatchMapping("/updatetodo")
    public ResponseEntity<?> updateTodo(@RequestBody TodoUpdateRequest todoUpdateRequest){
        return ResponseEntity.ok(todoServices.updateTodo(todoUpdateRequest));
    }
    @GetMapping("/viewtodo/{id}")
    public ResponseEntity<?> viewTodoById(@PathVariable String id){
    return ResponseEntity.ok(todoServices.viewTodoById(id));
    }
    @DeleteMapping("/deletetodo{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable String id){
        return ResponseEntity.ok(todoServices.deleteTodo(id));
    }
    @DeleteMapping("/cleartodo")
    public ResponseEntity<?> clearTodo(){
        return ResponseEntity.ok(todoServices.clearTodo());
    }

}
