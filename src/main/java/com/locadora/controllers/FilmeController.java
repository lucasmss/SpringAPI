package com.locadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.locadora.models.Filme;
import com.locadora.repositories.FilmeRepository;
@Controller
public class FilmeController {
	
	@Autowired
	FilmeRepository fr;
	
	@RequestMapping(value="/cadasFilme", method=RequestMethod.GET)
	public String form() {
		return "filme/cadasFilme";
	}
	
	@RequestMapping(value="/cadasFilme", method=RequestMethod.POST)
	public String form(Filme filme) {
		
		fr.save(filme);
		
		return "redirect:/cadasFilme";
	}
	
	@RequestMapping("/filmes")
	public ModelAndView listaFilmes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Filme> filmes = fr.findAll();
		mv.addObject("filmes", filmes);
		return mv;
	}
	
	
}
