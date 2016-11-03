package com.makerwei.repository;

import com.makerwei.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by weixianbin on 16/10/12.
 */
@Repository
public interface ArticleRepo extends JpaRepository<Article,Long> {
    List<Article> findAll();
    Article save(Article newArticle);

}
