package com.springapplication.mamager.services;

import com.springapplication.mamager.model.Family;
import com.springapplication.mamager.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FamilyService {
    private FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public List<Family> selectAllFamilies(){
        return (List<Family>) familyRepository.findAll();
    }

    public void addFamily(Family family){
        familyRepository.save(family);
    }

    public void deleteFamily(int id){
        Optional<Family> family = familyRepository.findById(id);
        if(family.isPresent()){
            familyRepository.delete(family.get());
        }

    }

    public void updateFamily(Family family){
        Optional<Family> familyToBeUpdated = familyRepository.findById(family.getId());
        if(familyToBeUpdated.isPresent()){
            familyToBeUpdated.get().setName(family.getName());
            familyRepository.save(familyToBeUpdated.get());
        }
    }

    public Optional<Family> selectFamilyById(int id){
        return familyRepository.findById(id);
    }

    public List<Family> selectFamiliesByName(String nameGiven){
        return (List<Family>) familyRepository.getFamiliesByName(nameGiven);
    }

}
