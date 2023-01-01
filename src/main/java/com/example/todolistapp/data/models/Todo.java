package com.example.todolistapp.data.models;

import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Document
@Data
public class Todo {
    @Id
    private String id;
    private EventStatus eventStatus;
    private EventCategories eventCategory;
    private String title;
    private String content;
    private LocalDate date;
    private LocalTime time;
}
