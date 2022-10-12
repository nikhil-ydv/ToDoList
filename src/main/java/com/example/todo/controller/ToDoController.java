package com.example.todo.controller;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class ToDoController {
    @Autowired
    ToDoService toDoService;
    @GetMapping("/allItems")
    ResponseEntity<List<ToDo>> getAllItems() {
        return new ResponseEntity<>(toDoService.allItems(),HttpStatus.OK);
    }

    @GetMapping("/allItems/{id}")
    ResponseEntity<ToDo> getItemById(@PathVariable(value = "id") long itemId ) {

        return ResponseEntity.ok(toDoService.itemById(itemId));
    }

    @PostMapping("/newItem")
    public ResponseEntity<?> createItem(@RequestBody ToDo toDo) {
        toDoService.createItem(toDo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/updateItem/{id}")
    public ResponseEntity<ToDo> updateItem(@PathVariable(value = "id") long id, @RequestBody ToDo updatedItem) {
        toDoService.updateItem(id, updatedItem);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable(value = "id") long id) {
        toDoService.deleteItemById(id);
        return ResponseEntity.ok().build();
    }

}
