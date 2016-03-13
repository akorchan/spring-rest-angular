package com.levi9.boilerplate.spring.services.impl;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi9.boilerplate.spring.domain.Article;
import com.levi9.boilerplate.spring.domain.repositories.ArticleRepository;
import com.levi9.boilerplate.spring.services.ArticleService;

/**
 * @author Andrey Korchan
 * @since 13-Mar-16 10:31
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public void saveArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article findOne(long id) {
        return articleRepository.findOne(id);
    }

    @Override
    public void delete(long id) {
        articleRepository.delete(id);
    }

    @Override
    public List<Article> findByTitle(String title) {
        return articleRepository.findByTitle(title);
    }

    @Override
    public List<Article> findByAuthor(String author) {
        return articleRepository.findByAuthor(author);
    }

    @Override
    public List<Article> findByTitleAndAuthor(String title, String author) {
        return articleRepository.findByTitleAndAuthor(title, author);
    }

}
