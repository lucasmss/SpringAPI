package com.locadora.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.locadora.models.Filme;
import com.locadora.services.FilmesService;

public class FilmeController {
	
	@Autowired
	FilmesService filmesService;
	
	@RequestMapping(value = "/pesquisa", method = RequestMethod.GET)
	public List<Filme> getFilms() {
		
		List<Filme> filme = filmesService.findAll();
		
		return filme;
	}

}
