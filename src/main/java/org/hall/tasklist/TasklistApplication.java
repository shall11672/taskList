package org.hall.tasklist;

import java.util.List;

import javax.transaction.Transactional;

import org.hall.tasklist.domain.Task;
import org.hall.tasklist.domain.TaskList;
import org.hall.tasklist.domain.TaskTag;
import org.hall.tasklist.domain.User;
import org.hall.tasklist.repo.TaskListRepo;
import org.hall.tasklist.repo.TaskRepo;
import org.hall.tasklist.repo.TaskTagRepo;
import org.hall.tasklist.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TasklistApplication implements CommandLineRunner {

  @Autowired
  private UserRepo userRepo;
  
  @Autowired
  private TaskListRepo listRepo;
  
  @Autowired
  private TaskRepo taskRepo;
  
  @Autowired
  private TaskTagRepo taskTagRepo;
  
	public static void main(String[] args) {
		SpringApplication.run(TasklistApplication.class, args);
	}

	@Transactional
  @Override
  public void run(String... args) throws Exception {
    
    //Create some data to play with
    User jonSnow = new User("jsnow", "Jon", "Snow", "jsnow@example.com");
    userRepo.save(jonSnow);
    
    User ariaStark = new User("astark", "Aria", "Stark", "astark@example.com");
    userRepo.save(ariaStark);

    // Tags
    TaskTag familyTag = new TaskTag("Family");
    familyTag =  taskTagRepo.save(familyTag);
    TaskTag dutyTag = new TaskTag("Duty");
    dutyTag = taskTagRepo.save(dutyTag);
    
    // Jon's list
    TaskList jonTaskList = new TaskList("Jon's To-Do List", jonSnow);
    jonTaskList = listRepo.save(jonTaskList);
    
    Task task1 = new Task("Find Mance Rayder.", jonTaskList);
    task1.getTaskTags().add(dutyTag);
    task1 = taskRepo.save(task1);
    jonTaskList.addTask(task1);
    
    Task task2 = new Task("Find Uncle Ben.", jonTaskList);
    task2.getTaskTags().add(familyTag);
    task2.getTaskTags().add(dutyTag);
    taskRepo.save(task2);
    jonTaskList.addTask(task2);
    
    Task task3 = new Task("Avenge Ned.", jonTaskList);
    task3.getTaskTags().add(familyTag);
    taskRepo.save(task3);
    jonTaskList.addTask(task3);
    
    
    List<TaskList> allTaskLists = listRepo.findAll();
    
    allTaskLists.stream().forEach(e -> System.out.println(e));
    
    allTaskLists.get(0).getTasks().stream().forEach(e -> System.out.println(e));
    
    allTaskLists.get(0).getTasks().iterator().next().getTaskTags().forEach(e -> System.out.println(e));
    
    System.out.println("find by tag name:");
    List<Task> familyTaggedTasks = taskRepo.findByTags_Name("Family");
    familyTaggedTasks.stream().forEach(e -> System.out.println(e));
    
    System.out.println("Find by owner:");
    List<TaskList> findByOwner_Login = listRepo.findByOwner_Login("jsnow");
    findByOwner_Login.stream().forEach(e -> System.out.println(e));
    
  }
}

