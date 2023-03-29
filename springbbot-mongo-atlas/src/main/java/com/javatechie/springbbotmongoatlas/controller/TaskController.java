package com.javatechie.springbbotmongoatlas.controller;
import java.util.List;
import com.javatechie.springbbotmongoatlas.model.Task;
import com.javatechie.springbbotmongoatlas.service.TaskService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import java.net.URLDecoder;

@RestController
//@RequestMapping("/tasks")
@RequestMapping
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
        return service.addTask(task);
    }



    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTasks() {
        return service.findAllTasks();
    }

    @GetMapping(value = "/{taskId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Task getTask(@PathVariable String taskId){
        return service.getTaskByTaskId(taskId);
    }


    @GetMapping(value = "/name/{name}")
    public List<Task> getTaskByName(@PathVariable String name){
        return service.getTaskByName(name);
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Task>> findTaskUsingid(@PathVariable int id) {
        try {
            List<Task> tasks = service.getTaskByid(id);
            if (tasks.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/language/{language}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Task> getTaskBylanguage(@PathVariable String language){
        return service.getTaskBylanguage(language);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Task modifyTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }
}
