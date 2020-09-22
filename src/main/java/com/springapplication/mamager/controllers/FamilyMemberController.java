package com.springapplication.mamager.controllers;

import com.springapplication.mamager.model.Family;
import com.springapplication.mamager.model.FamilyMember;
import com.springapplication.mamager.repositories.FamilyMemberRepository;
import com.springapplication.mamager.services.FamilyMemberService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedStoredProcedureQuery;
import java.util.List;

@RestController
public class FamilyMemberController {

    private final FamilyMemberService familyMemberService;

    public FamilyMemberController(FamilyMemberService familyMemberService) {
        this.familyMemberService = familyMemberService;
    }

    @GetMapping("/get-all-family-members")
    @ResponseBody
    public List<FamilyMember> getAllFamilyMembers(){
        return familyMemberService.getAllFamilyMembers();
    }


    @PostMapping(value = "/add-family-member",
    consumes = "application/json",
    produces = "application/json")
    public void addFamilyMember(@RequestBody FamilyMember familyMember){
       familyMemberService.addFamilyMember(familyMember);
    }

    @DeleteMapping("/delete-family-member/{id}")
    public void deleteFamilyMember(@PathVariable int id){
        familyMemberService.deleteFamilyMember(id);
    }

    @PutMapping(value = "/update-family-member",
            consumes = "application/json",
            produces = "application/json")
    public void updateFamilyMember(@RequestBody  FamilyMember familyMember){
        System.out.println(familyMember);
        familyMemberService.updateFamilyMember(familyMember);
    }
}
