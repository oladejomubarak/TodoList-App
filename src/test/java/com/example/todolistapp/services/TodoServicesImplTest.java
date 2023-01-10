package com.example.todolistapp.services;

import com.example.todolistapp.data.models.EventCategories;
import com.example.todolistapp.data.models.EventStatus;
import com.example.todolistapp.data.models.Todo;
import com.example.todolistapp.dtos.request.CreateTodoRequest;
import com.example.todolistapp.dtos.request.TodoUpdateRequest;
import com.example.todolistapp.dtos.response.CreateTodoResponse;
import com.example.todolistapp.dtos.response.GetResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TodoServicesImplTest {
    @Autowired
    private TodoServices todoServices;
    private CreateTodoRequest createTodoRequest;
    private CreateTodoRequest createTodoRequest1;
    private CreateTodoRequest createTodoRequest2;
    private CreateTodoRequest createTodoRequest3;

    @BeforeEach
    void setUp() {
        createTodoRequest = new CreateTodoRequest();
        createTodoRequest.setTitle("My examination");
        createTodoRequest.setContent("I have demo exam");
        createTodoRequest.setEventCategory(EventCategories.EDUCATION);
        createTodoRequest.setEventStatus(EventStatus.PENDING);
        createTodoRequest.setDate("20/01/2023");
        createTodoRequest.setTime("10:23");




    }
    @Test
    void testThatTodoCanBeCreated(){
        CreateTodoResponse createTodoResponse = todoServices.createTodo(createTodoRequest);
        assertEquals("todo created successfully", createTodoResponse.getMessage());

    }
    @Test void testThatTodoCanBeUpdated(){
        TodoUpdateRequest todoUpdateRequest = new TodoUpdateRequest();
       todoUpdateRequest.setId("63b5389142536c76818fb0ab");
       todoUpdateRequest.setTitle("new title");
       todoUpdateRequest.setContent("new plan");
       todoUpdateRequest.setDate("25/02/2023");
       todoUpdateRequest.setEventCategory(EventCategories.GAME);
        todoUpdateRequest.setTime("12:43");
       GetResponse updateResponse = todoServices.updateTodo(todoUpdateRequest);

        assertEquals("todo updated successfully", updateResponse.getMessage());

    }
    @Test void testThatTodoCanBeViewedById(){
        Todo todoToBeViewed = todoServices.viewTodoById("63b59032da4c3111429801af");
        assertEquals("I have demo exam", todoToBeViewed.getContent());
    }
//    @Test void testThatTodoCanBeViewedByDate(){
//        var viewByDate = todoServices.viewTodoByDate("20/01/2023");
//
//
//        //var todoListForTheDay = List.of(viewByDate);
//        System.out.println(viewByDate);
//    }
    @Test void testThatTodoCanBeDeleted(){
        GetResponse deleteTodo = todoServices.deleteTodo("63b5938a9baed3429bca5b4b");
        assertEquals("Todo deleted successfully", deleteTodo.getMessage());
    }
    @Test void testThatAlTodosCanBeCleared(){
        GetResponse clearTodo = todoServices.clearTodo();
        assertEquals("All todo have been cleared", clearTodo.getMessage());
    }
}