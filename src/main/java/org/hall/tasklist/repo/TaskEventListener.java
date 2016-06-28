package org.hall.tasklist.repo;

import org.hall.tasklist.domain.Task;
import org.hall.tasklist.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler(Task.class)
public class TaskEventListener {

  @Autowired
  private NotificationService notificationService;
  
  @HandleAfterSave
  public void handleAfterTaskSave(Task task)
  {
    if (task.isCompletionInd())
    {
      notificationService.taskCompleted(task);
    }
  }
}
