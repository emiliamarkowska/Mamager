package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.FamilyMember;
import org.springframework.data.repository.CrudRepository;

public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Integer> {
}
