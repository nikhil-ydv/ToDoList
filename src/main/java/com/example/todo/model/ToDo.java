package com.example.todo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table( name = "todolist")
public class ToDo implements Serializable {
    @Id
    private Long id;

    @Column(columnDefinition = "text")
    @NotBlank
    private String item;

    public Long getId() {
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
