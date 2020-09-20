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

    public Parent(int id, FamilyMember familyMember) {
        this.id = id;
        this.familyMember = familyMember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FamilyMember getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(FamilyMember familyMember) {
        this.familyMember = familyMember;
    }
}
