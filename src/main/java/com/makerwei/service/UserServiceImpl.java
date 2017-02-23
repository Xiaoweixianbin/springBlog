package com.makerwei.service;

import com.makerwei.entity.User;
import com.makerwei.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weixianbin
 * @date 2017/2/23
 * Copyright (C) 2014-2017 All Rights Reserved.
 */

@Service
public class UserServiceImpl {
    protected Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }


    public ResponseEntity<User> create(User user){
        if (user == null){
            throw new UsernameNotFoundException("It have some problems");
        }
        User saved = userRepo.save(user);
        return new ResponseEntity<User>(saved, HttpStatus.CREATED);
    }

    public ResponseEntity<User> delete(Long id){
        User user = userRepo.findOne(id);
        if (user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        userRepo.delete(id);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<User> update(Long id, User user){
        User currentUser = userRepo.findOne(id);
        if (currentUser == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
        userRepo.save(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    public ResponseEntity<List<User>>  getUserList(){
        List<User> userList = userRepo.findAll();
        if (userList.size() == 0){
            return new ResponseEntity<List<User>>(userList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }

    public ResponseEntity<User> getUser(Long id){
        User user = userRepo.findOne(id);
        if (user == null){
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }
}
