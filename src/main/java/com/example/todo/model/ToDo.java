package com.example.todo.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Table( name = "todolist")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "text")
    @NotBlank
    private String item;

    public long getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(String item) {
        this.item = item;
    }
}