package com.locadora.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.locadora.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

}
