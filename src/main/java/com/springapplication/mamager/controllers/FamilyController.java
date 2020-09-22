package com.springapplication.mamager.controllers;

import com.springapplication.mamager.model.Family;
import com.springapplication.mamager.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FamilyController {
    private final FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping("/get-all-families")
    @ResponseBody
    public List<Family> getAllPeople(){
        return familyService.selectAllFamilies();
    }

    @PostMapping(value = "/add-family",
    consumes = "application/json",
    produces = "application/json")
    public void addFamily(@RequestBody Family family){
        familyService.addFamily(family);
    }

    @DeleteMapping("/delete-family/{id}")
    public void deleteFamily(@PathVariable int id){
        familyService.deleteFamily(id);
    }

    @PutMapping(value = "/update-family",
            consumes = "application/json",
            produces = "application/json")
    public void updateFamily(@RequestBody Family family){
        familyService.updateFamily(family);
    }

    @GetMapping("/get-family-by-id/{id}")
    public Optional<Family> selectFamilyById(@PathVariable int id){
        return familyService.selectFamilyById(id);
    }

    @GetMapping("/get-families-with-name/{name}")
    public List<Family> selectFamiliesWithName(@PathVariable String name){
        return familyService.selectFamiliesByName(name);
    }
}
