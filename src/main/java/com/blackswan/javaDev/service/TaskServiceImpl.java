package com.blackswan.javaDev.service;

import com.blackswan.javaDev.dao.TaskDAO;
import com.blackswan.javaDev.dao.UserDAO;
import com.blackswan.javaDev.model.Task;
import com.blackswan.javaDev.model.User;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    private final UserDAO userDAO;
    private final TaskDAO taskDAO;

    public TaskServiceImpl(UserDAO userDAO, TaskDAO taskDAO) {
        this.userDAO = userDAO;
        this.taskDAO = taskDAO;
    }

    @Override
    public Task saveTask(Task task, Long id) {
        Optional<User> user = userDAO.findById(id);
        Task tsk = null;
        if (user.isPresent()) {
            User usr = user.get();
            task.setUser(usr);
            tsk = taskDAO.save(task);
        }
        return tsk;
    }

    @Override
    public Task updateTask(Task task, Long taskId) {
        Optional<Task> dbTask = taskDAO.findById(taskId);

        if (dbTask.isPresent()) {
            Task tsk = dbTask.get();
            tsk.setName(task.getName());
            task = taskDAO.save(tsk);
        }
        return task;
    }

    @Override
    public Boolean deleteTask(Long taskId) {
        taskDAO.deleteById(taskId);
        return true;
    }

    @Override
    public Task getTask(Long id) {
        return taskDAO.findById(id).get();
    }

    @Override
    public List<Task> getTasks(Long userId) {
        Optional<User> user = userDAO.findById(userId);
        Task tsk = null;
        if (user.isPresent()) {
            Task task = new Task();
            task.setUser(user.get());
            return taskDAO.findAll(Example.of(task));
        }
        return new ArrayList<>();
    }
}
