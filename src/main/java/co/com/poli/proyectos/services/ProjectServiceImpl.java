package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository repository;

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }

    @Override
    public Project create(Project project) {
        return repository.save(project);
    }
}
