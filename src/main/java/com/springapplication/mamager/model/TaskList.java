package com.springapplication.mamager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task_lists")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn(name = "family_id")
    private Family family;
    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Parent listCreator;

    public TaskList() {
    }

    public TaskList(Family family, Parent listCreator) {
        this.family = family;
        this.listCreator = listCreator;
    }

    public int getId() {
        return id;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Parent getListCreator() {
        return listCreator;
    }

    public void setListCreator(Parent listCreator) {
        this.listCreator = listCreator;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", family=" + family +
                ", listCreator=" + listCreator +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList taskList = (TaskList) o;

        return id == taskList.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
