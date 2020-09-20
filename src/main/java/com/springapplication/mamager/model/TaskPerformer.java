package com.springapplication.mamager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "task_to_family_member")
public class TaskPerformer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "task_performers_id")
    private FamilyMember taskPerformer;

    private boolean isDone;

    public TaskPerformer() {
    }

    public TaskPerformer(Task task, FamilyMember taskPerformer, boolean isDone) {
        this.task = task;
        this.taskPerformer = taskPerformer;
        this.isDone = isDone;
    }

    public int getId() {
        return id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public FamilyMember getTaskPerformer() {
        return taskPerformer;
    }

    public void setTaskPerformer(FamilyMember taskPerformer) {
        this.taskPerformer = taskPerformer;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "TaskPerformer{" +
                "id=" + id +
                ", task=" + task +
                ", taskPerformer=" + taskPerformer +
                ", isDone=" + isDone +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskPerformer that = (TaskPerformer) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
