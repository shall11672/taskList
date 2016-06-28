package org.hall.tasklist.service;

import org.hall.tasklist.domain.Task;
import org.springframework.stereotype.Service;

@Service
class NoOpNotificationServiceImpl implements NotificationService {

  @Override
  public void taskCompleted(Task task) {
    System.out.println("Send a notification for task: " + task);
  }

}
