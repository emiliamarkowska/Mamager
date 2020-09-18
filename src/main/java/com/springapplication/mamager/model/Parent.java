package com.springapplication.mamager.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "parents")
public class Parent {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "family_member_id")
    private FamilyMember familyMember;

    public Parent() {
    }

}
