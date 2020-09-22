package com.springapplication.mamager.services;

import com.springapplication.mamager.model.Family;
import com.springapplication.mamager.model.FamilyMember;
import com.springapplication.mamager.repositories.FamilyMemberRepository;
import com.springapplication.mamager.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transaction;
import java.sql.Connection;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FamilyService {
    private FamilyRepository familyRepository;
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository, FamilyMemberRepository familyMemberRepository) {
        this.familyRepository = familyRepository;
        this.familyMemberRepository = familyMemberRepository;
    }

    public List<Family> selectAllFamilies(){
        return (List<Family>) familyRepository.findAll();
    }

    public void addFamily(Family family){
        familyRepository.save(family);
        List<FamilyMember> familyMembers = new ArrayList<>( family.getFamilyMembers());
        System.out.println(familyMembers.size());
        for(Iterator<FamilyMember> familyMemberIterator = familyMembers.iterator(); familyMemberIterator.hasNext();){
            FamilyMember familyMember = familyMemberIterator.next();
            familyMember.assignToFamily(family);
           familyMemberRepository.save(familyMember);
        }
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
