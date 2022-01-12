package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.exception.RecordNotFoundException;
import co.com.poli.proyectos.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
    @Override
    public ResponseEntity<Project> findByIdTasks(Long id)  {
        Optional<Project> project = Optional.of(repository.getById(id));
        if (project.isPresent()) {
            return new ResponseEntity<Project>(project.get(), HttpStatus.OK);
        } else {
            throw new RecordNotFoundException();
        }
    }

}
