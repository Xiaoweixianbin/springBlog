package com.makerwei.service;

import com.makerwei.entity.Article;
import com.makerwei.entity.User;
import com.makerwei.exception.ArticleNotFoundException;
import com.makerwei.repository.ArticleRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weixianbin
 * @date 2017/3/14
 * Copyright (C) 2014-2017 All Rights Reserved.
 */
@Service
public class ArticleServiceImpl {
    protected Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    private ArticleRepo articleRepo;
    @Autowired
    public ArticleServiceImpl(ArticleRepo articleRepo){
        this.articleRepo = articleRepo;
    }

    public ResponseEntity<Article> create(Article article) throws ArticleNotFoundException {
        if (article == null){
            throw new ArticleNotFoundException("Article haves some problems,try it again");
        }
        Article saved = articleRepo.save(article);
        return  new ResponseEntity<Article>(saved, HttpStatus.CREATED);
    }

    public ResponseEntity<Article> delete(Long id){
        Article article = articleRepo.findOne(id);
        if (article == null){
            return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
        }
        articleRepo.delete(id);
        return new ResponseEntity<Article>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<Article> update(Long id, Article article){
        Article currentArticle = articleRepo.findOne(id);
        if (currentArticle == null){
            return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
        }
        currentArticle.setInfo(article.getInfo());
        currentArticle.setTags(article.getTags());
        currentArticle.setTime(article.getTime());
        currentArticle.setTitle(article.getTitle());
        articleRepo.save(currentArticle);
        return new ResponseEntity<Article>(currentArticle,HttpStatus.OK);
    }

    public ResponseEntity<List<Article>> getArticleList(){
        List<Article> articleList = articleRepo.findAll();
        if (articleList.size() == 0){
            return new ResponseEntity<List<Article>>(articleList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Article>>(articleList,HttpStatus.OK);
    }

    public ResponseEntity<Article> getArticle(long id){
        Article article = articleRepo.findOne(id);
        if (article == null){
            return new ResponseEntity<Article>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }

}
