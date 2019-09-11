package com.carloseduardo.cursopv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.repositories.AlunoRepository;
import com.carloseduardo.cursopv.services.exception.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repo;
	
	public Aluno find(Integer id) {
		Optional<Aluno> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}
/*
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Aluno update(Aluno obj) {
		find(obj.getId());
		return repo.save(obj);
	}
*/
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}
}
