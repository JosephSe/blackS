package com.blackswan.javaDev.service;

import com.blackswan.javaDev.dao.UserDAO;
import com.blackswan.javaDev.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    UserDAO mockUserDAO;

    @Autowired
    @Qualifier("userService")
    private UserService underTest;

    @Test
    public void testGet() {
        User user = new User();
        given(mockUserDAO.findById(1l)).willReturn(Optional.of(user));
        User result = underTest.get(1L);
        assertThat(result).isNotNull();
    }

    @Test
    public void testSave() {
        User user = new User();
        given(mockUserDAO.save(user)).willReturn(user);
        User result = underTest.save(user);
        assertThat(result).isNotNull();
    }
}
