package com.example.todolistapp.data.repository;

import com.example.todolistapp.data.models.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TodoRepository extends MongoRepository<Todo, String> {
    Optional<Todo> findTodoByDate(LocalDate date);

}
