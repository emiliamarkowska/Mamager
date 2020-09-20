package com.springapplication.mamager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private TaskList list;
    private String description;

    public Task() {
    }

    public Task(TaskList list, String description) {
        this.list = list;
        this.description = description;
    }

    public int getId() {
        return id;
    }


    public TaskList getList() {
        return list;
    }

    public void setList(TaskList list) {
        this.list = list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", list=" + list +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return id == task.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
