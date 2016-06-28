package org.hall.tasklist.repo;

import org.hall.tasklist.domain.TaskTag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskTagRepo  extends JpaRepository<TaskTag, Long> {

}
