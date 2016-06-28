package org.hall.tasklist.repo;

import java.util.List;

import org.hall.tasklist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskRepo extends JpaRepository<Task, Long> {

  List<Task> findByTags_Name(@Param("tagName") String name);
}
