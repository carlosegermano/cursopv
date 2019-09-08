package com.carloseduardo.cursopv;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.repositories.AlunoRepository;

@SpringBootApplication
public class CursopvApplication implements CommandLineRunner {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursopvApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Aluno aluno1 = new Aluno(null, "Mariana Melícia", "8985762", "marimel@gmail.com", "09898795564");
		
		alunoRepository.saveAll(Arrays.asList(aluno1));
	}

}
