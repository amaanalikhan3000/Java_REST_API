package com.javatechie.springbbotmongoatlas.repository;

import com.javatechie.springbbotmongoatlas.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findByid(int id);

    @Query("{ language: ?0 }")
    List<Task> getTasksBylanguage(String language);


    @Query("{ name: ?0 }")
    List<Task> getTasksByName(String name);
}

