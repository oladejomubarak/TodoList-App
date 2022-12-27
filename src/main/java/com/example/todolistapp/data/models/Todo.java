package com.example.todolistapp.data.models;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Todo {
    private String id;
    private EventStatus eventStatus;
    private EventCategories eventCategory;
    private String title;
    private String content;
    private LocalDateTime localDateTime;
}
