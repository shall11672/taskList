package org.hall.tasklist.service;

import org.hall.tasklist.domain.Task;

public interface NotificationService {

  void taskCompleted(Task task);
}
