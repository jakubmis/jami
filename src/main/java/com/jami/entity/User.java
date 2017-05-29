package com.jami.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jakub.mis on 5/22/2017.
 */
@Data
@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "LOGIN", nullable = false)
    private String login;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;

    public static User createUser(Integer integer) {
        User user = new User();
        user.setId(integer);
        user.setLogin("TEST"+integer);
        user.setPassword("TEST"+integer);
        user.setCreationDate(new Date());
        return user;
    }


}
