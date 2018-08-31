package com.blackswan.javaDev.dao;

import com.blackswan.javaDev.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Long> {
}
