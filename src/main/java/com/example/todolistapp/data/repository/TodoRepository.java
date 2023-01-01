package com.example.todolistapp.data.repository;

import com.example.todolistapp.data.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {

}
