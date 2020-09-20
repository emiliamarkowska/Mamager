package com.springapplication.mamager.model;

import javax.persistence.*;

@Entity
@Table(name = "children")
public class Child {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "family_member_id")
    private FamilyMember familyMember;

    public Child() {
    }

    public Child(int id, FamilyMember familyMember) {
        this.id = id;
        this.familyMember = familyMember;
    }

    public int getId() {
        return id;
    }

    public FamilyMember getFamilyMember() {
        return familyMember;
    }

    public void setFamilyMember(FamilyMember familyMember) {
        this.familyMember = familyMember;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", familyMember=" + familyMember +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Child child = (Child) o;

        return id == child.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
