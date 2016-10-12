package com.makerwei.entity;

import javax.persistence.*;

/**
 * Created by weixianbin on 16/10/12.
 */
@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String time;
    private String tag;
}
