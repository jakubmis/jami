package com.jami.domain.domains;

import com.jami.domain.models.User;
import com.jami.persistence.IUserPersistence;
import com.jami.utils.Response;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mis on 2017-07-10.
 */
@Service
public class AuthenticationDomain {

    private IUserPersistence userPersistence;

    public AuthenticationDomain(IUserPersistence userPersistence) {
        this.userPersistence = userPersistence;
    }

    @Transactional
    public Response registerUser(User user) {
        if (!user.getLogin().isValid()) {
            return Response.create("Login for user is not correct");
        }
        if (!user.getPassword().isValid()) {
            return Response.create("Password for user is not correct");
        }
        if (userPersistence.findByLogin(user.getLogin().getValue()).isPresent()) {
            return Response.create("System user already exists!");
        }
        userPersistence.save(user);
        return Response.success();
    }

    @Transactional(readOnly = true)
    public Response<List<User>> getUsers() {
        List<User> all = userPersistence.findAll();
        return Response.create(all, Response.OK);
    }
}
