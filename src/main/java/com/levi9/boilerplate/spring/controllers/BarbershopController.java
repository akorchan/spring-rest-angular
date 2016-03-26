package com.levi9.boilerplate.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.levi9.boilerplate.spring.domain.Barbershop;
import com.levi9.boilerplate.spring.services.BarbershopService;

/**
 * @author Andrey Korchan
 * @since 26-Mar-16 11:21
 */
@RestController
@RequestMapping("/api")
public class BarbershopController {

    @Autowired
    BarbershopService barbershopService;

    /**
     * Returns all existed barbershops.
     *
     * @return all barbershops
     */
    @RequestMapping(value = "/barbershops", method = RequestMethod.GET)
    public List<Barbershop> getBarbershops() {
        return barbershopService.findAll();
    }

    /**
     * Returns barbershop by id.
     *
     * @param id to find barbershop
     * @return barbershop by id
     */
    @RequestMapping(value = "/barbershops/{id}", method = RequestMethod.GET)
    public Barbershop getBarbershop(@PathVariable("id") final long id) {
        return barbershopService.findOne(id);
    }

    /**
     * Add new barbershop.
     *
     * @param barbershop barbershop to add
     * @return newly added barbershop
     */
    @RequestMapping(value = "/barbershops", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Barbershop addBarbershop(@RequestBody final Barbershop barbershop) {
        barbershopService.saveBarbershop(barbershop);
        return barbershop;
    }

    /**
     * Udates existed barbershop.
     *
     * @param barbershop barbershop to update
     * @return updated barbershop
     */
    @RequestMapping(value = "/barbershops/{id}", method = RequestMethod.PUT)
    public Barbershop updateBarbershop(@PathVariable("id") final long id, @RequestBody final Barbershop barbershop) {
        barbershop.setId(id);
        barbershopService.saveBarbershop(barbershop);
        return barbershop;
    }

    /**
     * Deletes existed Barbershop by id.
     *
     * @param id of barbershop that should be deleted
     * @return id of deleted barbershop
     */
    @RequestMapping(value = "/barbershops/{id}", method = RequestMethod.DELETE)
    public long deleteBarbershop(@PathVariable("id") final long id) {
        barbershopService.delete(id);
        return id;
    }
    
}
