package com.example.todo.controller;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    ToDoService toDoService;

    @GetMapping("/allItems")
    List<ToDo> getAllItems() {
        return toDoService.allItems();
    }

    @GetMapping("/allItems/{id}")
    ToDo getItemById(@PathVariable(value = "id") long itemId ) {
        return toDoService.itemById(itemId);
    }

    @PostMapping("/newItem")
    public String createItem(@RequestBody ToDo toDo) {
        return toDoService.createItem(toDo);
    }
    @PutMapping("/updateItem/{id}")
    public ResponseEntity<?> updateItem(@PathVariable(value = "id") long id, @RequestBody ToDo updatedItem) {
        return toDoService.updateItem(id, updatedItem);
    }

}
