package com.example.todolistapp.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum EventCategories {
    FASHION, MEETING, VACATION, SPORT, EDUCATION, PROJECT, GAME
}
