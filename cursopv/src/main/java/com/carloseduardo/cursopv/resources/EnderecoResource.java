package com.carloseduardo.cursopv.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carloseduardo.cursopv.domain.Endereco;
import com.carloseduardo.cursopv.services.EnderecoService;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoResource {

	@Autowired
	private EnderecoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Endereco obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}
}
