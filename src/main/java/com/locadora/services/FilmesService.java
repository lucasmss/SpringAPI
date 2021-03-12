package com.locadora.services;

import java.util.List;

import com.locadora.models.Filme;

public interface FilmesService {
	
	List<Filme> findAll();
	
	Filme findById(long id);
	
	Filme save(Filme filme);
	
	Filme update(Filme filme);
	
	Filme deleteById(long id);

}
