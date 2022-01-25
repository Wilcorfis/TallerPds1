package co.com.poli.proyectos.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Getter
@Setter
@Entity

@Table(name = "projectTask")
public class ProjectTask extends EntityBase {

    @Column(name="name")
    @NotEmpty
    @NotBlank
    private String name;

    @Column(name="summary")
    @NotEmpty
    @NotBlank
    private String summary;

    @Column(name="acceptance_criteria")
    private String acceptanceCriteria;



    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="priority")
    @Range(min = 1, max = 5)
    private int priority;

    @Column(name="hours")
    @Range(min = 1, max = 8)
    @Min(value = 0L)
    private Double hours;

    @Column(name="start_date")
    private Date startDate;

    @Column(name="end_date")
    private Date endDate;

    @Column(name="project_identifier", updatable=false)
    private String projectIdentifier;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="backlog_id")
    @NotEmpty
    @NotBlank
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
