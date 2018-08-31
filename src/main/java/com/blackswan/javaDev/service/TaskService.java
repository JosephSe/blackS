package com.blackswan.javaDev.service;

import com.blackswan.javaDev.model.Task;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task, Long id);

    Task updateTask(Task task, Long taskId);

    Boolean deleteTask(Long taskId);

    Task getTask(Long id);

    List<Task> getTasks(Long userId);

    void updateStatus();

}
