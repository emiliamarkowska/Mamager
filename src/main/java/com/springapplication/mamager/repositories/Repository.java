package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.Person;

import java.util.List;

public interface Repository {
    public List<Person> getPeople();
}
