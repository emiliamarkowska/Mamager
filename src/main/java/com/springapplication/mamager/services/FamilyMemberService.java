package com.springapplication.mamager.services;

import com.springapplication.mamager.model.FamilyMember;
import com.springapplication.mamager.repositories.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyMemberService {
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    public FamilyMemberService(FamilyMemberRepository familyMemberRepository) {
        this.familyMemberRepository = familyMemberRepository;
    }

    public List<FamilyMember> getAllFamilyMembers(){
        return (List<FamilyMember>) familyMemberRepository.findAll();
    }

    public void addFamilyMember(FamilyMember familyMember){
        familyMemberRepository.save(familyMember);
    }

    public void deleteFamilyMember(int id){
        Optional<FamilyMember> familyMember =  familyMemberRepository.findById(id);
        familyMemberRepository.delete(familyMember.get());
    }

    public void updateFamilyMember(FamilyMember familyMember){
        Optional<FamilyMember> familyMember1 = familyMemberRepository.findById(familyMember.getId());
        if(familyMember1.isPresent()){
            familyMember1.get().setName(familyMember.getName());
            familyMember1.get().setFamily(familyMember.getFamilyObject());
            familyMember1.get().setRole(familyMember.getRole());
            familyMemberRepository.save(familyMember1.get());
        }
    }
    
}
