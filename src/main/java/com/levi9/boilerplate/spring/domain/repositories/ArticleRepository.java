package com.levi9.boilerplate.spring.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi9.boilerplate.spring.domain.Article;

/**
 * @author Andrey Korchan
 * @since 13-Mar-16 10:36
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByTitle(String title);

    List<Article> findByAuthor(String author);

    List<Article> findByTitleAndAuthor(String title, String author);
}