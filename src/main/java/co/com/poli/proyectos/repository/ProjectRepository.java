package co.com.poli.proyectos.repository;

import co.com.poli.proyectos.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

}
