package com.makerwei;

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

    @Autowired
    private ArticleRepo articleRepo;

    @GetMapping
    public String getArticles() {
        JSONObject response = null;
        List<Article> articles = articleRepo.findAll();
        if (!articles.isEmpty()) {
            response.put("status", 200);
            response.put("articles", articles);
        }
        return response.toJSONString();
    }

    @GetMapping(value = "/{id}")
    public String getIndex(@PathVariable Long id) {
        JSONObject response = null;
        Article article = articleRepo.findOne(id);
        if (article != null) {
            response.put("status", 200);
            response.put("articles", article);
        }
        return response.toJSONString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteArtcle(@PathVariable Long id){
        JSONObject response = null;
        articleRepo.delete(id);
        response.put("status", 200);
        return response.toJSONString();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String PutArticle(@PathVariable Long id){
        JSONObject response = null;
        return response.toJSONString();
    }
}
