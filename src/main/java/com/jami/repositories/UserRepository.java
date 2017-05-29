package com.jami.repositories;

import com.jami.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by jakub.mis on 5/22/2017.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
