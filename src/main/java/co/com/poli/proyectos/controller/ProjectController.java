package co.com.poli.proyectos.controller;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService service;
    @GetMapping
    public List<Project> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public List<Project> findByIdTasks(@PathVariable Long id){
        return service.findByIdTasks(id);
    }
    //findByIdTasks
    @PostMapping
    public Project create(@RequestBody Project project){
        return service.create(project);
    }
}
