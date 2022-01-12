package co.com.poli.proyectos.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "projectTask")
public class ProjectTask extends EntityBase {

    @Column(name="name")
    @NotBlank(message = "Name may not be blank")
    private String name;

    @Column(name="summary")
    @NotBlank(message = "Name may not be blank")
    private String summary;

    @Column(name="acceptance_criteria")
    private String acceptanceCriteria;

    public enum Status {
        Not_STARTED, In_PROGRESS, COMPLETED, DELETED
    }

    @Column(name="status")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    @Column(name="priority")
    @Size(min = 1, max = 5, message = "Name must be between 1 and 5 characters long")
    private int priority;

    @Column(name="hours")
    @Min(value = 0L, message = "The value must be positive")
    @Size(min = 1, max = 8, message = "Name must be between 1 and 5 characters long")
    private Double hours;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="project_identifier", updatable=false)
    private String projectIdentifier;






    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
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
