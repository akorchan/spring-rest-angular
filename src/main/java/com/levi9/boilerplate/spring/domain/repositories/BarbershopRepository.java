package com.levi9.boilerplate.spring.domain.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.levi9.boilerplate.spring.domain.Barbershop;

/**
 * @author Andrey Korchan
 * @since 26-Mar-16 11:14
 */
public interface BarbershopRepository extends JpaRepository<Barbershop, Long> {

    List<Barbershop> findByName(String name);
}
