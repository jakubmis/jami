package com.jami.domain.models;

import com.jami.persistence.sql.entities.DbUser;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Mis on 2017-07-10.
 */
@Data
@Builder
public class User {

    private Login login;
    private Password password;

    public User(Login login, Password password) {
        Objects.requireNonNull(login, "password must be not null");
        Objects.requireNonNull(password, "password must be not null");
        this.login = login;
        this.password = password;
    }

    public DbUser toDbUser() {
        DbUser dbUser = new DbUser();
        dbUser.setLogin(login.getValue());
        dbUser.setPassword(password.getValue());
        dbUser.setCreationDate(new Date());
        return dbUser;
    }
}
