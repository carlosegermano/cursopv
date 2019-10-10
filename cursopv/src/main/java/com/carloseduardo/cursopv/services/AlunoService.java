package com.carloseduardo.cursopv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.dto.AlunoDTO;
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

	public Aluno insert(Aluno obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir aluno sem excluir o endereço e seus telefones");
		}
	}
	
	public List<Aluno> findAll(){
		return repo.findAll();
	}
	
	public Aluno fromDTO(AlunoDTO objDto) {
		return new Aluno(objDto.getId(), objDto.getNome(), objDto.getMatricula(), objDto.getEmail(),null);
	}
	
	private void updateDate(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
}
