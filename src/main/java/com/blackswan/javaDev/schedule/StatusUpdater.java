package com.blackswan.javaDev.schedule;

import com.blackswan.javaDev.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class StatusUpdater {

    private final TaskService taskService;

    private static final Logger log = LoggerFactory.getLogger(StatusUpdater.class);

    public StatusUpdater(TaskService taskService) {
        this.taskService = taskService;
    }

    @Scheduled(cron = "0 0 * * * *") //  the top of every hour of every day.
    public void updateStatus() {
        taskService.updateStatus();
    }
}
