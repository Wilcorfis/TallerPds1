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
    public List<ProjectTask> findByIdeTasks(String id)  {
        List<Project> p=findAll();
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getProjectIdentifier().equals(id)){
                return p.get(i).getBacklog().getProjectTasks();
            }
        }
        throw new  RecordNotFoundException();
    }
    @Override
    public double totaldeHoras (String id){
        double horas=0;
        List<ProjectTask> p=findByIdeTasks(id);
        for (int i = 0; i < p.size(); i++) {
            if(!p.get(i).getStatus().equals("DELETED")) {
                horas += p.get(i).getHours();
            }

        }
        return horas;
    }
    @Override
    public double totaldeHorasEstado (String id,String estado){
        double horas=0;
        List<ProjectTask> p=findByIdeTasks(id);
        for (int i = 0; i < p.size(); i++) {
            if(p.get(i).getStatus().equals(estado)) {
                horas += p.get(i).getHours();
            }
        }
        return horas;
    }
    @Override
    public ProjectTask deleteTask(Long idtask,String id) {
        ProjectTaskService service = new ProjectTaskServiceImpl();
        List<ProjectTask> p=findByIdeTasks(id);
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getId()==idtask){
                return service.delete(p.get(i));

            }

        }
        throw new  RecordNotFoundException();
    }
}
