package com.locadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.locadora.models.Filme;
import com.locadora.services.FilmesService;
@Controller
public class FilmeController {
	
	@Autowired
	FilmesService fs;
	
	@RequestMapping(value="/cadasFilme", method=RequestMethod.GET)
	public String form() {
		return "filme/cadasFilme";
	}
	
	@RequestMapping(value="/cadasFilme", method=RequestMethod.POST)
	public String form(Filme filme) {
		
		fs.save(filme);
		
		return "redirect:/cadasFilme";
	}
	
	@RequestMapping(value="/filmes", method=RequestMethod.GET)
	public ModelAndView listaFilmes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Filme> filmes = fs.findAll();
		mv.addObject("filmes", filmes);
		return mv;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ModelAndView detalhesFilme(@PathVariable("id") long id) {
		Filme filme = fs.findById(id);
		ModelAndView mv = new ModelAndView("filme/detalhesFilme");
		mv.addObject("filme", filme);
		return mv;
	}
	
	@RequestMapping(value="/deletar")
	public String deletarFilme(long id) {
		Filme filme = fs.findById(id);
		fs.deleteById(id);
		return "redirect:/filmes";
	}
	
	@RequestMapping(value="/atualizarFilme/{id}", method=RequestMethod.GET)
	public ModelAndView atualizarFilmeVer(@PathVariable("id") long id) {
		Filme filme = fs.findById(id);
		ModelAndView mv = new ModelAndView("filme/atualizarFilme");
		mv.addObject("filme", filme);
		return mv;
	}
	
	@RequestMapping(value="/atualizarFilme/{id}", method=RequestMethod.POST)
	public String atualizarFilme(@PathVariable Integer id, @ModelAttribute("atualizarFilme") Filme filme) {
		fs.update(filme);
		return "redirect:/filmes";
	}
	
	
}
