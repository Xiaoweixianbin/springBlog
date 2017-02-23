package com.makerwei.controller;
import com.alibaba.fastjson.JSON;
import com.makerwei.entity.User;
import com.makerwei.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author weixianbin
 * @date 2016/12/28 Copyright (C) 2014-2016 All Rights Reserved.
 */
@RestController
@RequestMapping("/users")
public class UserController {


  @Autowired
  private UserServiceImpl userServiceImpl;

  @PostMapping(consumes = "application/json; charset=utf-8")
  public ResponseEntity<User> register(@RequestBody String user) {
    User newUser = JSON.parseObject(user, User.class);
    return userServiceImpl.create(newUser);
  }



  @GetMapping(value = "/{id}", produces = "application/json; charset=utf-8")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    return userServiceImpl.getUser(id);
  }


  @GetMapping(produces = "application/json; charset=utf-8")
  public ResponseEntity<List<User>> getUserList() {
    return userServiceImpl.getUserList();
  }


  @DeleteMapping(value = "/{id}", produces = "application/json; charset=utf-8")
  public ResponseEntity<User> deleteUser(@PathVariable Long id) {
    return userServiceImpl.delete(id);
  }

  @PutMapping(value = "{id}", consumes = "application/json; charset=utf-8")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody String user) {
    User newUser = JSON.parseObject(user, User.class);
    return userServiceImpl.update(id, newUser);
  }
}
