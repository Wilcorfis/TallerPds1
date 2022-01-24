package co.com.poli.proyectos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name="project")
public class Project extends EntityBase{
    @NotEmpty(message = "Name may not be blank")
    @NotNull
    @Column(name="project_name",unique=true)
    private String projectName;

    @Size(min = 5, max = 7)
    @NotEmpty (message = "Name may not be blank")
    @NotNull  
    @Column(name="project_identifier",unique=true, updatable=false)
    private String ProjectIdentifier;

    @NotEmpty (message = "Name may not be blank")
    @NotNull
    @Column(name="description")
    

    private String description;

    @Column(name="start_date")
    private Date startDate;
    @Column(name="end_date")
    private Date endDate;


    @JsonManagedReference
    @OneToOne(mappedBy = "project",cascade = CascadeType.ALL)
    @JoinColumn(name="backlog_id")
    private Backlog backlog;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
