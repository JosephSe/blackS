package com.blackswan.javaDev.service;

import com.blackswan.javaDev.dao.TaskDAO;
import com.blackswan.javaDev.dao.UserDAO;
import com.blackswan.javaDev.model.Task;
import com.blackswan.javaDev.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskServiceTest {

    @MockBean
    TaskDAO mockTaskDAO;

    @MockBean
    UserDAO mockUserDAO;

    @Autowired
    @Qualifier("taskService")
    private TaskService underTest;

    @Test
    public void testGet() {
        Task task = new Task();
        given(mockTaskDAO.findById(1l)).willReturn(Optional.of(task));
        Task result = underTest.getTask(1L);
        assertThat(result).isNotNull();
    }

    @Test
    public void testGetTasks() {
        User user = new User();
        given(mockUserDAO.findById(1L)).willReturn(Optional.of(user));

        Task task = new Task();
        task.setUser(user);
        given(mockTaskDAO.findAll(Example.of(task))).willReturn(Collections.emptyList());

        List<Task> result = underTest.getTasks(1L);

        assertThat(result).isNotNull();
    }
}
