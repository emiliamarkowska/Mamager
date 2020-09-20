package com.springapplication.mamager.repositories;

import com.springapplication.mamager.model.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
