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


}
