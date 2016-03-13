package com.levi9.boilerplate.spring.services;

import java.util.List;

import com.levi9.boilerplate.spring.domain.Article;

/**
 * @author Andrey Korchan
 * @since 13-Mar-16 10:28
 */
public interface ArticleService {
    List<Article> findAll();
    void saveArticle(Article article);
    Article findOne(long id);
    void delete(long id);
    List<Article> findByTitle(String title);
    List<Article> findByAuthor(String author);
    List<Article> findByTitleAndAuthor(String title, String author);
}
