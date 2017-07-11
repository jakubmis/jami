package com.jami.persistence;

import com.jami.domain.models.User;
import com.jami.persistence.sql.entities.DbUser;

import java.util.List;
import java.util.Optional;

/**
 * Created by Mis on 2017-07-11.
 */
public interface IUserPersistence
{
    List<User> findAll();

    void save(User user);

    Optional<User> findByLogin(String login);
}
