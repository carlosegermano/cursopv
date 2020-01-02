package com.carloseduardo.cursopv.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.domain.Desempenho;
import com.carloseduardo.cursopv.domain.Disciplina;
import com.carloseduardo.cursopv.domain.Endereco;
import com.carloseduardo.cursopv.domain.Professor;
import com.carloseduardo.cursopv.repositories.AlunoRepository;
import com.carloseduardo.cursopv.repositories.DesempenhoRepository;
import com.carloseduardo.cursopv.repositories.DisciplinaRepository;
import com.carloseduardo.cursopv.repositories.EnderecoRepository;
import com.carloseduardo.cursopv.repositories.ProfessorRepository;

@Service
public class DBService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private DesempenhoRepository desempenhoRepository;
	
	public void instantiateDatabase() {

		Aluno aluno1 = new Aluno(null, "Mariana Melícia", "8985762", "marimel@gmail.com", "09898795564");
		Aluno aluno2 = new Aluno(null, "Jorge Delsalto", "2215424", "jorge@gmail.com", "22356545245");
		Aluno aluno3 = new Aluno(null, "Emília Santos", "5524542", "emilia@gmail.com", "00121222212");
		Aluno aluno4 = new Aluno(null, "Maria Silva", "2212121", "msilva@gmail.com", "22155487598");
		Aluno aluno5 = new Aluno(null, "Alberto Santos", "0012102", "alberto@gmail.com", "99875487545");

		Endereco end1 = new Endereco(null, "Rua Livroeira", "345", "Centro", "56485710", aluno1);
		Endereco end2 = new Endereco(null, "Rua da Esquina", "541", "Centro", "21254785", aluno2);
		Endereco end3 = new Endereco(null, "Rua Tenório", "221", "Centro", "65254545", aluno3);
		Endereco end4 = new Endereco(null, "Rua Mantis", "201", "Centro", "66565474", aluno4);
		Endereco end5 = new Endereco(null, "Rua Soute", "321", "Centro", "33254145", aluno5);

		aluno1.getEnderecos().addAll(Arrays.asList(end1));
		aluno2.getEnderecos().addAll(Arrays.asList(end2));
		aluno3.getEnderecos().addAll(Arrays.asList(end3));
		aluno4.getEnderecos().addAll(Arrays.asList(end4));
		aluno5.getEnderecos().addAll(Arrays.asList(end5));
		aluno1.getTelefones().addAll(Arrays.asList("(83) 987575744", "(83) 998956985"));

		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2, aluno3, aluno4, aluno5));
		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4, end5));

		Disciplina disc1 = new Disciplina(null, "378756", "Física");
		Disciplina disc2 = new Disciplina(null, "378486", "Matemática");

		disc1.getAlunos().addAll(Arrays.asList(aluno1));
		disc2.getAlunos().addAll(Arrays.asList(aluno1));

		aluno1.getDisciplinas().addAll(Arrays.asList(disc1, disc2));

		disciplinaRepository.saveAll(Arrays.asList(disc1, disc2));

		Professor prof1 = new Professor(null, "João Rocha", "Graduação", "55658478545", disc1);
		Professor prof2 = new Professor(null, "Leonardo França", "Mestre", "55458569856", disc2);

		professorRepository.saveAll(Arrays.asList(prof1, prof2));

		Desempenho d1 = new Desempenho(null, 9.4, 7.8, 8.0, 10.0, 10.0, 9.5, 7.7, 8.5, 6.5, 10.0, 8.74, aluno1);

		desempenhoRepository.saveAll(Arrays.asList(d1));
	}
}
