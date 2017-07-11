package com.jami.persistence.postgres;

import com.jami.domain.models.User;
import com.jami.persistence.IUserPersistence;
import com.jami.persistence.spring.repositories.UserRepository;
import com.jami.persistence.sql.entities.DbUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Mis on 2017-07-11.
 */
@Repository("postgres")
public class UserPersistence implements IUserPersistence{

    private UserRepository userRepository;

    public UserPersistence(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll()
                .stream()
                .map(DbUser::toUser)
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        userRepository.save(user.toDbUser());
    }

    @Override
    public Optional<User> findByLogin(String value) {
        return userRepository
                .findByLogin(value)
                .map(DbUser::toUser);
    }
}
