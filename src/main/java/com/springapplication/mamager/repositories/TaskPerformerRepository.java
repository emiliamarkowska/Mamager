package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.TaskPerformer;
import org.springframework.data.repository.CrudRepository;

public interface TaskPerformerRepository extends CrudRepository<TaskPerformer, Integer> {
}
