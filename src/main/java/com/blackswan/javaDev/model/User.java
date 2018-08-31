package com.blackswan.javaDev.model;

import lombok.Data;

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

    public void setId(Long id) {
        this.id = id;
    }
}
