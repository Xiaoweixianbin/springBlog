package com.makerwei.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by weixianbin on 16/10/12.
 * 用户 ： 创建，读取，删除
 * 文章 ： 创建，读取，更新，删除
 * 评论 ： 创建，读取，删除
 */

@Entity
public class Admin {
    @OneToMany(mappedBy = "admin")
    private Set<Article> articles = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /* 顺序号 */
    private Long id;
    @Column(name = "username")
    /* 用户名 */
    private String username;
    @Column(name = "password")
    /* 用户密码 */
    private String password;
    @Column(name = "lastlogintime")
    /* 上次登录时间 */
    private String lastLoginTime;
    @Column(name = "role")
    private String role;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }
}
