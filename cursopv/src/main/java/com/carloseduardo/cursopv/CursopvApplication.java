package com.carloseduardo.cursopv;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.domain.Endereco;
import com.carloseduardo.cursopv.repositories.AlunoRepository;
import com.carloseduardo.cursopv.repositories.EnderecoRepository;

@SpringBootApplication
public class CursopvApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursopvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno aluno1 = new Aluno(null, "Mariana Melícia", "8985762", "marimel@gmail.com", "09898795564");
		
		Endereco end1 = new Endereco(null, "Rua Livroeira", "345", "Centro", "56485710", aluno1);
		
		aluno1.getEnderecos().addAll(Arrays.asList(end1));
		aluno1.getTelefones().addAll(Arrays.asList("(83) 987575744", "(83) 998956985"));
		
		alunoRepository.saveAll(Arrays.asList(aluno1));
		enderecoRepository.saveAll(Arrays.asList(end1));
		
	}

}
