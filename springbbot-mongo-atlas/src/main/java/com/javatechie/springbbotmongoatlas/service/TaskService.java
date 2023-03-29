package com.javatechie.springbbotmongoatlas.service;


import com.javatechie.springbbotmongoatlas.model.Task;
import com.javatechie.springbbotmongoatlas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    //CRUD  CREATE , READ , UPDATE , DELETE


    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);
    }

    public List<Task> findAllTasks() {
        return repository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return repository.findById(taskId).get();
    }

//    public List<Task> getTaskByName(String name){
//        return repository.getTasksBylanguage(name);
//    }

//    public List<Task> getTaskByName(String name){
//        return repository.getTasksByName(name);
//    }

    public List<Task> getTaskByid(int id){
        return  repository.findByid(id);
    }



    public List<Task> getTaskBylanguage(String language){
        return repository.getTasksBylanguage(language);
    }

    public List<Task> getTaskByName(String name){
        return repository.getTasksByName(name);
    }

    public Task updateTask(Task taskRequest){
        //get the existing document from DB
        // populate new value from request to existing object/entity/document
        Task existingTask = repository.findById(taskRequest.getTaskId()).get();
        existingTask.setName(taskRequest.getName());
        existingTask.setId(taskRequest.getId());
        existingTask.setLanguage(taskRequest.getLanguage());
        existingTask.setFramework(taskRequest.getFramework());
        return repository.save(existingTask);
    }

    public String deleteTask(String taskId){
        repository.deleteById(taskId);
        return taskId+" task deleted from dashboard ";
    }
}