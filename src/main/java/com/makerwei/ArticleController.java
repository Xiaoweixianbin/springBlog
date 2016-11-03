package com.makerwei.user;

import com.makerwei.entity.Article;
import com.makerwei.repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.persistence.Table;

/**
 * Created by weixianbin on 16/10/12.
 */
@RestController
public class ArticleController {

    @Autowired
    private ArticleRepo articleRepo;


    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String getArticles() {
        return "hello world";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "hedfsdfsdgdsg";
    }
}
