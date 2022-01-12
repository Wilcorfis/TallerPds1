package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.entities.ProjectTask;
import co.com.poli.proyectos.exception.RecordNotFoundException;
import co.com.poli.proyectos.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
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

    /*public List<Project> findByIdTasks(Long id)  {
        return repository.findAllById(Collections.singleton(id));
    }*/
    @Override
    public Project findByIdeTasks(Long id)  {
        String str = id+"";

        List<Project> p=findAll();
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getProjectIdentifier().equals(str)){
                return p.get(i);

            }

        }

        throw new  RecordNotFoundException();
    }

}
