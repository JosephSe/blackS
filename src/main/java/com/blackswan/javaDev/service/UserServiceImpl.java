package com.blackswan.javaDev.service;

import com.blackswan.javaDev.dao.UserDAO;
import com.blackswan.javaDev.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User get(Long id) {
        Optional<User> user = userDAO.findById(id);
        return user.get();
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public List<User> all() {
        return userDAO.findAll();
    }

    @Override
    public User update(User user) {
        return userDAO.save(user);
    }

}
