package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAll();
    Project create(Project project);
}
