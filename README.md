A taskList in Spring Boot using Spring Data REST.

Build:
requires Java 8
./gradlew build

Users:
jsnow  password1
astark password2

The jsnow user has a task list with tasks and associated tags.

Runs at: http://localhost:8080

Operations:

GET http://localhost:8080/taskLists/search/findByOwner_Login?login={userName}
Returns a HATEOAS decorated JSON response contains the user's task lists

GET http://localhost:8080/taskLists
Returns all the task lists

PUT Creates a new entity for the end point.
POST Updates an existing entity for an end point.
DELETE Removes an entity for an end point.

eg
PUT http://localhost:8080/taskLists
Content-Type : application/json
{"name": "Jon's Other To-Do List",
 "owner": "http://localhost:8080/users/1"
}
Creates another task list for user Jon Snow

eg
POST http://localhost:8080/taskLists
Content-Type : application/json
{
  "id": "1",
  "name": "Jon's Fancy To-Do List",
  "owner": "http://localhost:8080/users/1"
}

GET http://localhost:8080/taskLists/1
Returns a particular task list

GET http://localhost:8080/taskLists/1/tasks
Returns the tasks for a particular task list

GET http://localhost:8080/tasks/1
Returns a particular task

GET http://localhost:8080/tasks/1/tags
Returns tags for a particular task


