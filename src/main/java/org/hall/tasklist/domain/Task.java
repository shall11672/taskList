package org.hall.tasklist.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A Task.
 */
@Entity
@Table(name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    Task(){}; // JPA
    
    public Task(String desc, TaskList taskList)
    {
      this.description = desc;
      this.taskList = taskList;
      this.completeDate = null;
      this.createDate= LocalDate.now();
      this.completionInd = false;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Column(name = "completion_ind", nullable = false)
    private Boolean completionInd;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "complete_date")
    private LocalDate completeDate;

    @ManyToOne
    private TaskList taskList;

    @ManyToMany
    @JoinTable(
        name="task_tag",
        joinColumns=@JoinColumn(name="TASK_ID", referencedColumnName="ID"),
        inverseJoinColumns=@JoinColumn(name="TAG_ID", referencedColumnName="ID"))
    private List<TaskTag> tags = new ArrayList<>();;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isCompletionInd() {
        return completionInd;
    }

    public void setCompletionInd(Boolean completionInd) {
        this.completionInd = completionInd;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalDate getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(LocalDate completeDate) {
        this.completeDate = completeDate;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public List<TaskTag> getTaskTags() {
        return tags;
    }

    public void setTaskTags(List<TaskTag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        if(task.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Task{" +
            "id=" + id +
            ", description='" + description + "'" +
            ", completionInd='" + completionInd + "'" +
            ", createDate='" + createDate + "'" +
            ", completeDate='" + completeDate + "'" +
            '}';
    }
}
