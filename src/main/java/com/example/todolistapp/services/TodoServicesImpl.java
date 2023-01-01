package com.example.todolistapp.services;

import com.example.todolistapp.data.models.Todo;
import com.example.todolistapp.data.repository.TodoRepository;
import com.example.todolistapp.dtos.request.CreateTodoRequest;
import com.example.todolistapp.dtos.request.TodoUpdateRequest;
import com.example.todolistapp.dtos.response.CreateTodoResponse;
import com.example.todolistapp.dtos.response.GetResponse;
import com.example.todolistapp.dtos.response.TodoUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TodoServicesImpl implements TodoServices{
    @Autowired
    private TodoRepository todoRepository;
    private final Todo todo = new Todo();


    @Override
    public CreateTodoResponse createTodo(CreateTodoRequest createTodoRequest) {
    todo.setTitle(createTodoRequest.getTitle());
    todo.setContent(createTodoRequest.getContent());
    todo.setEventCategory(createTodoRequest.getEventCategory());
    todo.setDate(LocalDate.parse(createTodoRequest.getDate()));
    todo.setTime(LocalTime.parse(createTodoRequest.getTime()));
    todo.setEventStatus(createTodoRequest.getEventStatus());
//    todo.setDueDateAndTime(createTodoRequest.getMonth());
//    todo.setDueDateAndTime(createTodoRequest.getDay());
//    todo.setDueDateAndTime(createTodoRequest.getMonth());
//    todo.setDueDateAndTime(createTodoRequest.getMinute());
//    todo.setDueDateAndTime(createTodoRequest.getHour());
            //.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a")));
    Todo savedTodo = todoRepository.save(todo);
    CreateTodoResponse createTodoResponse = new CreateTodoResponse();
    createTodoResponse.setMessage("todo created successfully");
    createTodoResponse.setId(savedTodo.getId());
    createTodoResponse.setStatusCode("201");
        return createTodoResponse;
    }

    @Override
    public GetResponse updateTodo(TodoUpdateRequest todoUpdateRequest) {
         Todo createdTodo = todoRepository.findById(todoUpdateRequest.getId()).orElseThrow(()->
                 new RuntimeException("todo not found"));
         createdTodo.setTitle(todoUpdateRequest.getTitle() != null && !todoUpdateRequest.getTitle().equals("")
                 ? todoUpdateRequest.getTitle() : createdTodo.getTitle());
         createdTodo.setContent(todoUpdateRequest.getContent() != null && !todoUpdateRequest.getContent().equals("")
         ? todoUpdateRequest.getContent() : createdTodo.getContent());
         createdTodo.setEventCategory(todoUpdateRequest.getEventCategory() != null ? todoUpdateRequest.getEventCategory()
                 : createdTodo.getEventCategory());
         createdTodo.setDate(todoUpdateRequest.getDate() != null && !todoUpdateRequest.getDate().equals("")
                 ? LocalDate.parse(todoUpdateRequest.getDate()) : createdTodo.getDate());
         createdTodo.setTime(todoUpdateRequest.getTime() != null && !todoUpdateRequest.getTime().equals("")
                 ? LocalTime.parse(todoUpdateRequest.getTime()) : createdTodo.getTime());
         createdTodo.setEventStatus(createdTodo.getEventStatus());
        todoRepository.save(createdTodo);
        return new GetResponse("todo updated successfully");
    }

    @Override
    public Todo viewTodoById(String id) {
        return todoRepository.findById(id).orElseThrow(()->
                new RuntimeException("todo with the id"+ id +"not found"));
    }

    @Override
    public List<Todo> viewTodoByDate(String date) {
        Todo foundTodo = todoRepository.findTodoByDate(LocalDate.parse(date)).orElseThrow(()->
                new RuntimeException("There is no task scheduled for the date"+ date +"\nTry another date"));
        List<Todo> todoList = List.of(foundTodo);

        return todoList;
    }

    @Override
    public GetResponse deleteTodo(String id) {
        todoRepository.deleteById(id);
        return new GetResponse("Todo deleted successfully");
    }

    @Override
    public GetResponse clearTodo() {
        todoRepository.deleteAll();
        return new GetResponse("All todo have been cleared");
    }
}
