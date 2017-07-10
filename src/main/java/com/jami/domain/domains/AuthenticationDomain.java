package com.jami.domain.domains;

import com.jami.domain.models.User;
import com.jami.persistence.entity.DbUser;
import com.jami.persistence.repositories.UserRepository;
import com.jami.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mis on 2017-07-10.
 */
@Service
public class AuthenticationDomain {

    private UserRepository userRepository;

    public AuthenticationDomain(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Response registerUser(User user) {
        if (!user.getLogin().isValid()) {
            return Response.create("Login for user is not correct");
        }
        if (!user.getPassword().isValid()) {
            return Response.create("Password for user is not correct");
        }
        if (userRepository.findByLogin(user.getLogin().getValue()).isPresent()) {
            return Response.create("System user already exists!");
        }
        userRepository.save(user.toDbUser());
        return Response.success();
    }

    @Transactional(readOnly = true)
    public Response<List<User>> getUsers() {
        List<DbUser> all = userRepository.findAll();
        List<User> collect = all.stream().map(DbUser::toUser).collect(Collectors.toList());
        return Response.create(collect, Response.OK);
    }
}
