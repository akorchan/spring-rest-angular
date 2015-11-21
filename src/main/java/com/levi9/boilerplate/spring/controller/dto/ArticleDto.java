package com.levi9.boilerplate.spring.controller.dto;

/**
 * @author Andrey Korchan
 * @since 21-Nov-15 16:31
 */
public class ArticleDto {

    private long id;
    private String content;

    // Dummy constructor for Jackson unmarshaling
    public ArticleDto() {
    }

    public ArticleDto(final long id, final String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
