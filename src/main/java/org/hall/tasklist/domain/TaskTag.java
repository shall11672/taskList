package org.hall.tasklist.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * A TaskTag.
 */
@Entity
@Table(name = "tag")
public class TaskTag implements Serializable {

    private static final long serialVersionUID = 1L;

    TaskTag(){};  //JPA
    
    public TaskTag(String name){
      this.name = name;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskTag taskTag = (TaskTag) o;
        if(taskTag.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, taskTag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "TaskTag{" +
            "id=" + id +
            ", name='" + name + "'" +
            '}';
    }
}
