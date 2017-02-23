package com.makerwei.repository;

import com.makerwei.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by weixianbin on 16/10/23.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    User findByUsername(String username);
    List<User> findAll();
}
