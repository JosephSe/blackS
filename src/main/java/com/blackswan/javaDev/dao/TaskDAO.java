package com.blackswan.javaDev.dao;

import com.blackswan.javaDev.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskDAO extends JpaRepository<Task, Long> {

//    @Query(value = "SELECT T FROM task T WHERE T.user_id = :id")
    List<Task> findByUserId(@Param("id") Long userId);
}
