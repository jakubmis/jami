package com.jami;

import com.jami.entity.User;
import com.jami.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Mis on 2017-05-29.
 */
@Component
public class Service {

    @Autowired
    UserRepository userRepository;

    @Autowired
    Service2 service2;


    @Transactional(propagation=Propagation.REQUIRED)
    public void test() {
        try {
            service2.test2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        userRepository.save(User.createUser(2));
    }

}
