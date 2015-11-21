package com.levi9.boilerplate.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.levi9.boilerplate.spring.controller.dto.ArticleDto;

/**
 * @author Andrey Korchan
 * @since 21-Nov-15 16:30
 */
@RestController
public class ArticlesController {

    private long articleId;

    /**
     * Returns all existed articles.
     *
     * @return all articles
     */
    @RequestMapping(value = "/api/articles", method = RequestMethod.GET)
    public List<ArticleDto> getArticles() {
        ArrayList<ArticleDto> listToReturn = new ArrayList<>();
        listToReturn.add(new ArticleDto(articleId, "Content of " + 1));
        listToReturn.add(new ArticleDto(articleId, "Content of " + 2));
        return listToReturn;
    }

    /**
     * Returns article by id.
     *
     * @param id to find article
     * @return article by id
     */
    @RequestMapping(value = "/api/articles/{id}", method = RequestMethod.GET)
    public ArticleDto getArticle(@PathVariable("id") final long id) {
        return new ArticleDto(id, "Content of " + id);
    }

    /**
     * Add new article.
     *
     * @param article article to add
     * @return newly added article
     */
    @RequestMapping(value = "/api/articles", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ArticleDto addArticle(@RequestBody final ArticleDto article) {
        articleId = article.getId();
        return new ArticleDto(article.getId(), article.getContent());
    }

    /**
     * Udates existed article.
     *
     * @param article article to update
     * @return updated article
     */
    @RequestMapping(value = "/api/articles", method = RequestMethod.PUT)
    public ArticleDto updateArticle(@RequestBody final ArticleDto article) {
        articleId = article.getId();
        return new ArticleDto(articleId, article.getContent());
    }

    /**
     * Deletes existed article by id.
     *
     * @param id of article that should be deleted
     * @return id of deleted article
     */
    @RequestMapping(value = "/api/articles/{id}", method = RequestMethod.DELETE)
    public long deleteArticle(@PathVariable("id") final long id) {
        articleId = 0;
        return id;
    }
}
