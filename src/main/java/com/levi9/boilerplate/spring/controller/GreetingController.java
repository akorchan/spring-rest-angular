package com.levi9.boilerplate.spring.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.levi9.boilerplate.spring.controller.dto.GreetingDto;

/**
 * @author Andrey Korchan
 * @since 01-Nov-15 16:03
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting",  method = RequestMethod.GET)
    public GreetingDto greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new GreetingDto(counter.incrementAndGet(), String.format(template, name));
    }
}
