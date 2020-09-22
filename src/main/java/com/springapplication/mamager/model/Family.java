package com.springapplication.mamager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "families")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "family", fetch = FetchType.LAZY)
    private List<FamilyMember> familyMembers = new ArrayList<>();


    public Family(){
    }

    public Family(String name) {
        this.name = name;
    }

    public Family(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Family(String name, List<FamilyMember> familyMembers) {
        this.name = name;
        this.familyMembers = familyMembers;
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

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMember> familyMembers) {
        this.familyMembers = familyMembers;
    }


    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Family that = (Family) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
