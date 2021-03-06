package com.jami.persistence.spring.repositories;

import com.jami.persistence.sql.entities.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by jakub.mis on 5/22/2017.
 */
public interface UserRepository extends JpaRepository<DbUser, Integer> {

    Optional<DbUser> findByLogin(String login);

}
