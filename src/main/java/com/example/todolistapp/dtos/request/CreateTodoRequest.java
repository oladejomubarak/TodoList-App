package com.example.todolistapp.dtos.request;

import com.example.todolistapp.data.models.DateAndTime;
import com.example.todolistapp.data.models.EventCategories;
import com.example.todolistapp.data.models.EventStatus;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class CreateTodoRequest {
    private EventStatus eventStatus;
    private EventCategories eventCategory;
    private String title;
    private String content;
    private String date;
    private String time;
//    private DateAndTime year;
//    private DateAndTime month;
//    private DateAndTime day;
//    private DateAndTime minute;
//    private DateAndTime hour;
}
