package com.jami.persistence.entity;

import com.jami.domain.models.Login;
import com.jami.domain.models.Password;
import com.jami.domain.models.User;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jakub.mis on 5/22/2017.
 */
@Data
@Entity
@Table(name = "USERS")
public class DbUser {

    @Id
    @GeneratedValue(generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "LOGIN", nullable = false)
    private String login;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "CREATION_DATE", nullable = false)
    private Date creationDate;


    public static User toUser(DbUser dbUser) {
        return User.builder()
                .login(new Login(dbUser.getLogin()))
                .password(new Password(dbUser.getPassword()))
                .build();
    }
}
