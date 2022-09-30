package com.example.todo.controller;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @GetMapping("/allItems")
    List<ToDo> getAllItems() {
        return toDoService.allItems();
    }

    @PostMapping("/newItem")
    public ToDo createItem(@RequestBody ToDo toDo) {
        return toDoService.createItem(toDo);
    }
}
