package org.hall.tasklist.repo;

import java.util.List;

import org.hall.tasklist.domain.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface TaskListRepo extends JpaRepository<TaskList, Long> {

  List<TaskList> findByOwner_Login(@Param("login") String login);
}
