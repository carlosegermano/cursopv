package com.carloseduardo.cursopv.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.domain.Disciplina;
import com.carloseduardo.cursopv.services.DisciplinaService;

@RestController
@RequestMapping(value="/disciplinas")
public class DisciplinaResource {

	@Autowired
	private DisciplinaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Disciplina obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> findAll() {
		
		List<Disciplina> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
