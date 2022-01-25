package co.com.poli.proyectos.services;

import co.com.poli.proyectos.entities.ProjectTask;

import co.com.poli.proyectos.entities.Status;
import co.com.poli.proyectos.exception.BadRequest;
import co.com.poli.proyectos.repository.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjectTaskServiceImpl implements ProjectTaskService{
    @Autowired
    private ProjectTaskRepository repository;
    @Override
    public List<ProjectTask> findAll() {
        return repository.findAll();
    }

    @Override
    public ProjectTask create(ProjectTask projectTask) {

        if(!projectTask.getName().trim().equals("") || !projectTask.getSummary().trim().equals("")){
            if(projectTask.getBacklog()!=null) {
                return repository.save(projectTask);
            }
        }
        if(!projectTask.getName().trim().equals("") && !projectTask.getSummary().trim().equals("")){
            if(projectTask.getBacklog()!=null) {
                return repository.save(projectTask);
            }
        }

        Map<String,Object> response = new HashMap<String,Object>();
        response.put("request",projectTask);
        response.put("status","success");
        throw new BadRequest();
        
    }

}
