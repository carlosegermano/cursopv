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

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.domain.Endereco;
import com.carloseduardo.cursopv.dto.AlunoDTO;
import com.carloseduardo.cursopv.dto.AlunoNewDTO;
import com.carloseduardo.cursopv.repositories.AlunoRepository;
import com.carloseduardo.cursopv.repositories.EnderecoRepository;
import com.carloseduardo.cursopv.services.exception.ObjectNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Aluno find(Integer id) {
		Optional<Aluno> obj = alunoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Aluno.class.getName()));
	}

	@Transactional
	public Aluno insert(Aluno obj) {
		obj.setId(null);
		obj = alunoRepository.save(obj);
		enderecoRepository.saveAll(obj.getEnderecos());
		return obj;
	}
	
	public Aluno update(Aluno obj) {
		Aluno newObj = find(obj.getId());
		updateDate(newObj, obj);
		return alunoRepository.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			alunoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possível excluir aluno sem excluir o endereço e seus telefones");
		}
	}
	
	public List<Aluno> findAll(){
		return alunoRepository.findAll();
	}
	
	public Aluno fromDTO(AlunoDTO objDto) {
		return new Aluno(objDto.getId(), objDto.getNome(), null, objDto.getEmail(), null);
	}
	
	public Aluno fromDTO(AlunoNewDTO objDto) {
		Aluno aluno = new Aluno(null, objDto.getNome(), objDto.getMatricula(), objDto.getEmail(), objDto.getCpfAluno());
		Endereco end = new Endereco(null, objDto.getLogradouro(), objDto.getNumero(), objDto.getBairro(), objDto.getCep(), aluno);
		aluno.getEnderecos().add(end);
		aluno.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) aluno.getTelefones().add(objDto.getTelefone2());
		if (objDto.getTelefone3() != null) aluno.getTelefones().add(objDto.getTelefone3());
		return aluno;
	}
	
	private void updateDate(Aluno newObj, Aluno obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	public Page<Aluno> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return alunoRepository.findAll(pageRequest);
	}
}
