package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.entities.ProjectTask;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project create(Project project);
    /*List<Project> findByIdTasks(Long id) ;*/
    Project findByIdeTasks(Long id) ;
}
