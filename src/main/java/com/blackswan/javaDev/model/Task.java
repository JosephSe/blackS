package com.blackswan.javaDev.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "task")
//@NoArgsConstructor
public class Task implements Serializable {
    private @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    private String name;
    private String description;
    private String date_time;
    private String status;

    public Task() {
        this.status = "pending";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Task markAsDone(){
        this.status = "Done";
        return this;
    }
}
