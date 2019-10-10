package com.carloseduardo.cursopv.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.carloseduardo.cursopv.domain.Aluno;

public class AlunoDTO {

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=100, message="O tamanho deve ser entre 5 e 80")
	private String nome;
	private String matricula;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	@Email(message="Email inválido!")
	private String email;
	
	public AlunoDTO() {}

	public Integer getId() {
		return id;
	}
	
	public AlunoDTO(Aluno obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.matricula = obj.getMatricula();
		this.email = obj.getEmail();
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

}
