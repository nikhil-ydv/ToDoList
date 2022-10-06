package com.example.todo.service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository todorepository;

    //get all items
    public List<ToDo> allItems() {
        return todorepository.findAll();
    }

    //find item by id
    public ToDo itemById(long itemId) {
        return todorepository.findById(itemId);
    }

    //add new item
    public String createItem(ToDo toDo) {
        todorepository.save(toDo);
        return "ToDo Item inserted successfully";
    }

    //update by id
    public ResponseEntity<?> updateItem(long id, ToDo updatedItem) {
        if(todorepository.existsById(id)) {
            ToDo toDo = todorepository.findById(id);
            toDo.setItem(updatedItem.getItem());
            ToDo newSavedItem = todorepository.save(toDo);
            return ResponseEntity.ok().build();
        }
        else
            return ResponseEntity.notFound().build();
    }


}
