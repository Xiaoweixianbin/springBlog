package com.makerwei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.makerwei.entity.Admin;
import com.makerwei.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author weixianbin
 * @date 2016/12/28
 * Copyright (C) 2014-2016 All Rights Reserved.
 */
@RestController
public class AdminController {
    @Autowired
    private AdminRepo adminRepo;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestBody String admin){
        Admin newAdmin = JSON.parseObject(admin, Admin.class);
        adminRepo.save(newAdmin);
        JSONObject response = new JSONObject();
        response.put("code",200);
        return response.toJSONString();
    }


}
