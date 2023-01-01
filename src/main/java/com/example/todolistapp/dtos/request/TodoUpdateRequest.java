package com.example.todolistapp.dtos.request;

import com.example.todolistapp.data.models.EventCategories;
import com.example.todolistapp.data.models.EventStatus;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TodoUpdateRequest {
    private String id;
    private EventStatus eventStatus;
    private EventCategories eventCategory;
    private String title;
    private String content;
    private String date;
    private String time;
    //private LocalDateTime dueDateAndTime;
}
