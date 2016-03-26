package com.levi9.boilerplate.spring.services;

import java.util.List;

import com.levi9.boilerplate.spring.domain.Barbershop;

/**
 * @author Andrey Korchan
 * @since 26-Mar-16 11:16
 */
public interface BarbershopService {
    List<Barbershop> findAll();
    void saveBarbershop(Barbershop barbershop);
    Barbershop findOne(long id);
    void delete(long id);
    List<Barbershop> findByName(String name);
}
