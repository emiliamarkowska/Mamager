package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.Child;
import org.springframework.data.repository.CrudRepository;

public interface ChildRepository extends CrudRepository<Child, Integer> {
}
