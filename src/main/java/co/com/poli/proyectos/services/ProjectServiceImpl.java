package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.Project;
import co.com.poli.proyectos.entities.ProjectTask;
import co.com.poli.proyectos.entities.Status;
import co.com.poli.proyectos.exception.BadRequest;
import co.com.poli.proyectos.exception.RecordNotFoundException;
import co.com.poli.proyectos.repository.ProjectRepository;
import co.com.poli.proyectos.repository.ProjectTaskRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository repository;
    @Autowired
    private ProjectTaskRepository repository2;

    @Override
    public List<Project> findAll() {
        return repository.findAll();
    }


    @Override
    public Project create( Project project) {
        if(!project.getProjectIdentifier().trim().equals("") || !project.getProjectName().trim().equals("")){
            if(project.getProjectIdentifier().length()>=5 && project.getProjectIdentifier().length()<=7){
                return repository.save(project);
            }

        }
        if(!project.getProjectIdentifier().trim().equals("") && !project.getProjectName().trim().equals("")){
            if(project.getProjectIdentifier().length()>=5 && project.getProjectIdentifier().length()<=7){
                return repository.save(project);
            }

        }

        Map<String,Object> response = new HashMap<String,Object>();
        response.put("request",project);
        response.put("status","success");
        throw new BadRequest();

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
            if(p.get(i).getStatus().toString().equals(estado)) {
                horas += p.get(i).getHours();
            }
        }
        return horas;
    }
    @Override
    public ProjectTask deleteTask(Long idtask,String id) {
        ProjectTaskServiceImpl service = new ProjectTaskServiceImpl();
        List<ProjectTask> p=findByIdeTasks(id);
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getId()==idtask){
                p.get(i).setStatus(Status.DELETED);
                repository2.delete(p.get(i));
                return p.get(i);

            }

        }
        throw new  RecordNotFoundException();
    }
}
