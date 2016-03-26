package com.levi9.boilerplate.spring.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levi9.boilerplate.spring.domain.Article;
import com.levi9.boilerplate.spring.domain.Barbershop;
import com.levi9.boilerplate.spring.domain.repositories.ArticleRepository;
import com.levi9.boilerplate.spring.domain.repositories.BarbershopRepository;
import com.levi9.boilerplate.spring.services.ArticleService;
import com.levi9.boilerplate.spring.services.BarbershopService;

/**
 * @author Andrey Korchan
 * @since 26-Mar-16 11:18
 */
@Service
@Transactional
public class BarbershopServiceImpl implements BarbershopService {

    @Autowired
    private BarbershopRepository barbershopRepository;

    @Override
    public List<Barbershop> findAll() {
        return barbershopRepository.findAll();
    }

    @Override
    public void saveBarbershop(Barbershop barbershop) {
        barbershopRepository.save(barbershop);
    }

    @Override
    public Barbershop findOne(long id) {
        return barbershopRepository.findOne(id);
    }

    @Override
    public void delete(long id) {
        barbershopRepository.delete(id);
    }

    @Override
    public List<Barbershop> findByName(String name) {
        return barbershopRepository.findByName(name);
    }
}
