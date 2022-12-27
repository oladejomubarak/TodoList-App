package com.example.todolistapp.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<TodoRepository, String> {
}
