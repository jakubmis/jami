package com.jami;

import com.jami.entity.User;
import com.jami.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by Mis on 2017-05-29.
 */
@Component
public class Service {

    @Autowired
    UserRepository userRepository;

    private String a;

    public void test(){
        userRepository.save(User.createUser(1));
        a.toCharArray();
        userRepository.delete(1);
    }
}
