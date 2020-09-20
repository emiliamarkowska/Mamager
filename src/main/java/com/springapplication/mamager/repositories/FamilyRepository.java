package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.Family;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<Family, Integer> {
}
