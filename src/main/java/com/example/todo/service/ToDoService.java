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
    //Response entity created("URI"???)
    public void createItem(ToDo toDo) {
        todorepository.save(toDo);
    }


    //update by id
    public ToDo updateItem(long id, ToDo updatedItem) {
            ToDo toDo = todorepository.findById(id);
            toDo.setItem(updatedItem.getItem());
            ToDo newSavedItem = todorepository.save(toDo);
            return newSavedItem;
    }

    //delete by id
    public void deleteItemById(long id) {
            todorepository.deleteById(id);
    }


}
