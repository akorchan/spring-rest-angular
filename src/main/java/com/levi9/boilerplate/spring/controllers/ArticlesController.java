package com.levi9.boilerplate.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.levi9.boilerplate.spring.domain.Article;
import com.levi9.boilerplate.spring.services.ArticleService;

/**
 * @author Andrey Korchan
 * @since 21-Nov-15 16:30
 */
@RestController
public class ArticlesController {

    @Autowired
    ArticleService articleService;

    /**
     * Returns all existed articles.
     *
     * @return all articles
     */
    @RequestMapping(value = "/api/articles", method = RequestMethod.GET)
    public List<Article> getArticles() {
        return articleService.findAll();
    }

    /**
     * Returns article by id.
     *
     * @param id to find article
     * @return article by id
     */
    @RequestMapping(value = "/api/articles/{id}", method = RequestMethod.GET)
    public Article getArticle(@PathVariable("id") final long id) {
        return articleService.findOne(id);
    }

    /**
     * Add new article.
     *
     * @param article article to add
     * @return newly added article
     */
    @RequestMapping(value = "/api/articles", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Article addArticle(@RequestBody final Article article) {
        articleService.saveArticle(article);
        return article;
    }

    /**
     * Udates existed article.
     *
     * @param article article to update
     * @return updated article
     */
    @RequestMapping(value = "/api/articles/{id}", method = RequestMethod.PUT)
    public Article updateArticle(@PathVariable("id") final long id, @RequestBody final Article article) {
        article.setId(id);
        articleService.saveArticle(article);
        return article;
    }

    /**
     * Deletes existed article by id.
     *
     * @param id of article that should be deleted
     * @return id of deleted article
     */
    @RequestMapping(value = "/api/articles/{id}", method = RequestMethod.DELETE)
    public long deleteArticle(@PathVariable("id") final long id) {
        articleService.delete(id);
        return id;
    }
}
