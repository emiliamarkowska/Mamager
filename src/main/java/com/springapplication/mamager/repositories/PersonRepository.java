package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
