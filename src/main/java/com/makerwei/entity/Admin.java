package com.makerwei.entity;



import org.hibernate.annotations.Cache;

import javax.persistence.*;

/**
 * Created by weixianbin on 16/10/12.
 */

@Entity
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /* 顺序号 */
    private Long id;
    @Column(name = "username")
    /* 用户名 */
    private String userName;
    @Column(name = "password")
    /* 用户密码 */
    private String passWord;
    @Column(name = "lastlogintime")
    /* 上次登录时间 */
    private String lastLoginTime;

}
