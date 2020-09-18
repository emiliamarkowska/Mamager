package com.springapplication.mamager.controllers;

import com.springapplication.mamager.model.Person;
import com.springapplication.mamager.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/get-people")
    @ResponseBody
    public List<Person> getAllPeople(){
        return personService.selectAllPeople();
    }
}
