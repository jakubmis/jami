package com.jami;

import com.jami.entity.User;
import com.jami.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mis on 2017-05-30.
 */
@Component
public class Service2 {


    @Autowired
    UserRepository userRepository;

    String a;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void test2() {
        userRepository.save(User.createUser(1));
        a.toCharArray();
    }
}
