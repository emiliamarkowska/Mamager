package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.Family;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FamilyRepository extends CrudRepository<Family, Integer> {
    @Query(value = "SELECT f.id, f.name FROM families f WHERE f.name = :nameGiven", nativeQuery = true)
    List<Family> getFamiliesByName(String nameGiven);
}
