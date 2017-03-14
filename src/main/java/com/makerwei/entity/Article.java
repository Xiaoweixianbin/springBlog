package com.makerwei.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by weixianbin on 16/10/12.
 */
@Entity
public class Article {
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property="id", scope=Article.class)
    private User user;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    /* 顺序号 */
    private Long id;
    @Column(name = "title")
    /* 文章名 */
    private String title;
    @Column(name = "time")
    /* 写作时间*/
    private String time;
    @Column(name = "tags")
    /* 标签 */
    private  String tags;
    @Column(name = "info")
    /* 内容 */
    private String info;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
