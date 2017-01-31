package com.makerwei.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.makerwei.entity.Article;
import com.makerwei.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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


    private ArticleRepo articleRepo;

    @Autowired
    public ArticleController(ArticleRepo articleRepo){
        this.articleRepo = articleRepo;
    }


    /**
     * 获取文章列表  GET方式  返回 json 格式
     * @return
     */
    @GetMapping
    public String getArticles() {
        JSONObject response = new JSONObject();
        List<Article> articles = articleRepo.findAll();
        response.put("articles",articles);
        return response.toJSONString();
    }


    /**
     * 获取某一篇文章 GET方式  返回 json 格式
     * @param id       文章的 id
     * @return
     */
    @GetMapping(value = "/{id}")
    public String getIndex(@PathVariable Long id) {
        JSONObject response = new JSONObject();
        Article article = articleRepo.findOne(id);
        if (article != null) {
            response.put("articles", article);
        }
        return response.toJSONString();
    }

    /**
     * 删除某篇文章
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}")
    public String deleteArticle(@PathVariable Long id){
        JSONObject response = new JSONObject();
        articleRepo.delete(id);
        response.put("status", 200);
        return response.toJSONString();
    }

    /**
     * 更新某篇文章
     * @param id
     * @param article
     * @return
     */
    @PutMapping(value = "/{id}")
    public String PutArticle(@PathVariable Long id,@RequestBody String article){
        JSONObject response = new JSONObject();
        Article newArticle = JSON.parseObject(article,Article.class);
        Article pastArticle = articleRepo.findOne(id);
        if (newArticle != null){
            newArticle.setId(pastArticle.getId());
        }
        articleRepo.save(newArticle);
        response.put("code","200");
        return response.toJSONString();
    }

    /**
     * 创建文章
     * @param article
     * @return
     */
    @PostMapping
    public String addArticle(@RequestBody String article){
        Article updateArticle = JSON.parseObject(article, Article.class);
        articleRepo.save(updateArticle);
        JSONObject response = new JSONObject();
        response.put("code",200);
        return response.toJSONString();
    }
}
