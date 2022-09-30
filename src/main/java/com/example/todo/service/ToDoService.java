package com.example.todo.service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository todorepository;

    public List<ToDo> allItems() {
        return todorepository.findAll();
    }

    public ToDo createItem(ToDo toDo) {
        return todorepository.save(toDo);
    }
}
