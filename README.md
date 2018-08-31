# Black Swan

## End points created
- [X] Create user - POST - http://localhost:8080/api/user
- [X] Update user - PUT - http://localhost:8080/api/user/{id}
- [X] List all users- GET - http://localhost:8080/api/user
- [X] Get User info - GET - http://localhost:8080/api/user/{id}
- [X] Create Task - POST -http://localhost:8080/api/user/{user_id}/task
- [X] Update Task - PUT - http://localhost:8080/api/user/{user_id}/task/{task_id}
- [X] Delete Task - DELETE - http://localhost:8080/api/user/{user_id}/task/{task_id}
- [X] Get Task Info - GET - http://localhost:8080/api/user/{user_id}/task/{task_id}
- [X] List all tasks for a user - GET - http://localhost:8080/api/user/{user_id}/task

### Bonus
- [X] scheduled job to check all tasks in the Database - those that have a status of "pending" and who date_time has passed - print it to the console and update the task to "done"