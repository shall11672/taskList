package org.hall.tasklist.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A TaskList.
 */
@Entity
@Table(name = "task_list")
public class TaskList implements Serializable {

    private static final long serialVersionUID = 1L;

    TaskList(){}; // JPA default const
    
    public TaskList(String name, User owner){
      this.name = name;
      this.owner = owner;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @NotNull
    private User owner;

    @OneToMany(mappedBy = "taskList")
    private Set<Task> tasks = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User user) {
        this.owner = user;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
      this.tasks.add(task);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskList taskList = (TaskList) o;
        if(taskList.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, taskList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
      
      StringBuilder b = new StringBuilder();
      b.append("TaskList{") 
            .append("id=")
            .append( id)
            .append(", name='")
            .append(name)
            .append("'")
            .append(", user='")
            .append(owner.toString())
            .append( "'");
      b.append('}').toString();
      return b.toString();
    }
}

