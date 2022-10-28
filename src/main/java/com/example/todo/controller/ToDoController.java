package com.example.todo.controller;

import com.example.todo.model.ToDo;
import com.example.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.Date;
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
        if(toDoService.itemExists(itemId)) {
            return ResponseEntity.ok(toDoService.itemById(itemId));
        }
        return ResponseEntity.notFound().build();

    }

    @PostMapping("/newItem")
    public ResponseEntity<?> createItem(@RequestBody ToDo toDo) {
        long itemId = toDo.getId();
        if(toDoService.itemExists(itemId) == false) {
            toDoService.createItem(toDo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @PutMapping("/updateItem/{id}")
    public ResponseEntity<ToDo> updateItem(@PathVariable(value = "id") long id, @RequestBody ToDo updatedItem) {
        if(toDoService.itemExists(id)) {
            toDoService.updateItem(id, updatedItem);
            return ResponseEntity.ok().build();
        }
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<?> deleteItemById(@PathVariable(value = "id") long id) {
        if(toDoService.itemExists(id)) {
            toDoService.deleteItemById(id);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

}
