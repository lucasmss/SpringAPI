package com.locadora.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.models.Filme;
import com.locadora.repositories.FilmeRepository;
import com.locadora.services.FilmesService;
@Service
public class FilmeServiceImpl implements FilmesService{
	
	@Autowired
	FilmeRepository filmeRepository;

	@Override
	public List<Filme> findAll() {
		
		return filmeRepository.findAll();
	}

	@Override
	public Filme findById(long id) {
		
		return filmeRepository.findById(id).get();
	}

	@Override
	public Filme save(Filme filme) {
		
		return filmeRepository.save(filme);
	}

	@Override
	public Filme update(long id) {
		
		filmeRepository.findById(id);
		
		return null;
	}

	@Override
	public Filme deleteById(long id) {
		filmeRepository.deleteById(id);
		return null;
	}

}
