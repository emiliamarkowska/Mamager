package com.springapplication.mamager.services;

import com.springapplication.mamager.model.Person;
import com.springapplication.mamager.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService {
    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> selectAllPeople(){
        return (List<Person>) personRepository.findAll();
    }
}
