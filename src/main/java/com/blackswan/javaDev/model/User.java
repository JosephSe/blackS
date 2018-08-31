package com.blackswan.javaDev.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
//@NoArgsConstructor
public class User implements Serializable {

    private @Id
    @GeneratedValue
    Long id;

    private String username;
    private String first_name;
    private String last_name;

    private @OneToMany(cascade = CascadeType.ALL)
    List<Task> tasks;

    public void setId(Long id) {
        this.id = id;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
