package com.springapplication.mamager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "family_members")
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id")
    private Family family;

    public FamilyMember() {
    }

    public FamilyMember(String name, Role role, @Lazy Family family) {
        this.name = name;
        this.role = role;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonIgnore
    public Family getFamilyObject() {
        return family;
    }

    public int getFamily(){
        return family.getId();
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void assignToFamily(Family family){
        family.getFamilyMembers().add(this);
        this.family = family;
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FamilyMember that = (FamilyMember) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
