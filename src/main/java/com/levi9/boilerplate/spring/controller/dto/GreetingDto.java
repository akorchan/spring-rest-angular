package com.levi9.boilerplate.spring.controller.dto;

/**
 * @author Andrey Korchan
 * @since 01-Nov-15 15:57
 */
public class GreetingDto {

    private final long id;
    private final String content;

    public GreetingDto(long id, String content) {
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
