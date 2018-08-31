package com.blackswan.javaDev.controller;

import com.blackswan.javaDev.model.Task;
import com.blackswan.javaDev.model.User;
import com.blackswan.javaDev.service.TaskService;
import com.blackswan.javaDev.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService userService;
    private final TaskService taskService;

    public UserController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    User getInfo(@PathVariable Long id) {
        return userService.get(id);
    }

    @GetMapping()
    List<User> all() {
        return userService.all();
    }

    @PostMapping()
    User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PutMapping({"/{id}"})
    User update(@RequestBody User user, @PathVariable Long id) {
        user.setId(id);
        return userService.save(user);
    }

    @PostMapping({"/{id}/task"})
    Task createTask(@RequestBody Task task, @PathVariable Long id) {
        return taskService.saveTask(task, id);
    }

    @PutMapping({"/{id}/task/{taskId}"})
    Task updateTask(@RequestBody Task task, @PathVariable Long taskId) {
        return taskService.updateTask(task, taskId);
    }

    @DeleteMapping({"/{id}/task/{taskId}"})
    Boolean deleteTask(@PathVariable Long taskId) {
        return taskService.deleteTask(taskId);
    }

    @GetMapping({"/{id}/task/{taskId}"})
    Task getTask(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }

    @GetMapping({"/{id}/task"})
    List<Task> getTasksByUser(@PathVariable Long id) {
        return taskService.getTasks(id);
    }

}
