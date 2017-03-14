package com.makerwei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.makerwei.entity.Article;
import com.makerwei.exception.ArticleNotFoundException;
import com.makerwei.repository.ArticleRepo;
import com.makerwei.service.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by weixianbin on 16/10/12.
 */
@RestController
@RequestMapping(value = "/v0.1/articles")
public class ArticleController {


    @Autowired
    private ArticleServiceImpl articleServiceImpl;




    /**
     * 获取文章列表  GET方式  返回 json 格式
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Article>> getArticles() {
        return articleServiceImpl.getArticleList();
    }


    /**
     * 获取某一篇文章 GET方式  返回 json 格式
     * @param id       文章的 id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Article> getArticles(@PathVariable Long id) {
        return articleServiceImpl.getArticle(id);
    }

    /**
     * 删除某篇文章
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Article> deleteArticle(@PathVariable Long id){
       return articleServiceImpl.delete(id);
    }

    /**
     * 更新某篇文章
     * @param id
     * @param article
     * @return
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Article> PutArticle(@PathVariable Long id,@RequestBody String article){

        Article newArticle = JSON.parseObject(article,Article.class);
        return articleServiceImpl.update(id, newArticle);
    }

    /**
     * 创建文章
     * @param article
     * @return
     */
    @PostMapping
    public ResponseEntity<Article> addArticle(@RequestBody String article) throws ArticleNotFoundException {
        Article newArticle = JSON.parseObject(article, Article.class);
        return articleServiceImpl.create(newArticle);
    }
}
