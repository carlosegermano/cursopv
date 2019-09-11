package com.carloseduardo.cursopv.dto;

import com.carloseduardo.cursopv.domain.Aluno;

public class AlunoDTO {

	private Integer id;
	private String nome;
	private String matricula;
	private String email;
	private String cpf;
	
	public AlunoDTO() {}

	public Integer getId() {
		return id;
	}
	
	public AlunoDTO(Aluno obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.matricula = obj.getMatricula();
		this.email = obj.getEmail();
		this.cpf = obj.getCpf();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
