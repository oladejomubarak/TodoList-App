package com.example.todolistapp.data.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Document
@Data
public class Todo {
    @Id
    private String id;
    private EventStatus eventStatus;
    private EventCategories eventCategory;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    private LocalTime time;

}
