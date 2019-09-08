package com.carloseduardo.cursopv.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carloseduardo.cursopv.domain.Aluno;

@RestController
@RequestMapping(value="/alunos")
public class AlunoResource {

	@RequestMapping(method=RequestMethod.GET)
	public List<Aluno> listar() {
		
		Aluno aluno1 = new Aluno(1, "Mariana Melícia", "8985762", "marimel@gmail.com", "098.987.955-64");
		
		List<Aluno> lista = new ArrayList<>();
		lista.add(aluno1);
		return lista;
	}
}
