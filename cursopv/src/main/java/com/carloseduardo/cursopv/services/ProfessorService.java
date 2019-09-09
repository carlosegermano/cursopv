package com.carloseduardo.cursopv.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloseduardo.cursopv.domain.Professor;
import com.carloseduardo.cursopv.repositories.ProfessorRepository;
import com.carloseduardo.cursopv.services.exception.ObjectNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repo;
	
	public Professor buscar(Integer id) {
		Optional<Professor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Professor.class.getName()));
	}
}
