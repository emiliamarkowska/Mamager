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
}
