package com.makerwei.entity;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by weixianbin on 16/10/12.
 */
@Entity
public class Article {
    @ManyToOne
    private Admin admin;

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

    protected Article() { }
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
