package com.carloseduardo.cursopv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carloseduardo.cursopv.domain.Disciplina;
import com.carloseduardo.cursopv.dto.DisciplinaDTO;
import com.carloseduardo.cursopv.repositories.DisciplinaRepository;
import com.carloseduardo.cursopv.repositories.ProfessorRepository;
import com.carloseduardo.cursopv.services.exception.ObjectNotFoundException;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repo;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	public Disciplina find(Integer id) {
		Optional<Disciplina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
	}
	
	public List<Disciplina> findAll(){
		return repo.findAll();
	}

	@Transactional
	public Disciplina insert(Disciplina obj) {
		obj.setId(null);
		obj = repo.save(obj);
		professorRepository.save(obj.getProfessor());
		return obj;
	}
	
	public Disciplina update(Disciplina obj) {
		Disciplina newObj = find(obj.getId());
		updateDate(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir disciplina que contenha relacionamentos!");
		}
	}
	
	public Disciplina fromDTO(DisciplinaDTO objDto) {
		return new Disciplina(objDto.getId(), objDto.getCodigo(), objDto.getNome());
	}
	
	private void updateDate(Disciplina newObj, Disciplina obj) {
		newObj.setCodigo(obj.getCodigo());
		newObj.setNome(obj.getNome());
	}
	
	public Page<Disciplina> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
