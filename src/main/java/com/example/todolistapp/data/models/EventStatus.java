package com.example.todolistapp.data.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum EventStatus {
    ACCOMPLISHED, PENDING
}
