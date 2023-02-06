package com.example.todolistapp.dtos.request;

import com.example.todolistapp.data.models.EventCategories;
import com.example.todolistapp.data.models.EventStatus;
import lombok.Data;

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

}
