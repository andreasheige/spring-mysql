package com.toto.todo.controller;

import java.util.List;

import javax.validation.Valid;

import com.toto.todo.exception.NotFoundException;
import com.toto.todo.model.Todo;
import com.toto.todo.repository.TodoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TodoAPI {

    @Autowired
    TodoRepository todoRepository;

    // Get all
    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    // Create
    @PostMapping("/todos")
    public Todo crateTodo(@Valid @RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    // Get by ID
    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable(value = "id") Long todoId) {
        return todoRepository.findById(todoId)
                .orElseThrow(() -> new NotFoundException("Todo", "Id", "todoId"));
    }

    // Update 
    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable(value = "id") Long todoId, 
                @Valid @RequestBody Todo todoDetails) {
        
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NotFoundException("Todo", "id", "todoId"));

                todo.setTitle(todoDetails.getTitle());
                todo.setContent(todoDetails.getContent());

                Todo updateTodo = todoRepository.save(todo);
                return updateTodo;
    }

    // Delete
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable(value = "id") Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NotFoundException("Todo", "id", "todoId"));

                todoRepository.delete(todo);

                return ResponseEntity.ok().build();
    }


}