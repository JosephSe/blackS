package com.blackswan.javaDev.service;

import com.blackswan.javaDev.model.User;

import java.util.List;

public interface UserService {
    User get(Long id);
    User save(User user);
    List<User> all();
    User update(User user);
}
