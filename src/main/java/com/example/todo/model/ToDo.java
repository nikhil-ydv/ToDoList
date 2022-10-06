package com.example.todo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

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