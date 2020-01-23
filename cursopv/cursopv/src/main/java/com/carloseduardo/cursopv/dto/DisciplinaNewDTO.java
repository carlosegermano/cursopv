package com.carloseduardo.cursopv.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class DisciplinaNewDTO {

	@NotEmpty(message="Campo de preenchimento obrigatório!")
	@Length(min=6, max=6, message="O tamanho do código deve ser 6 números!")
	private String codigo;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	private String nomeDisciplina;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	private String nomeProfessor;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	private String titulacao;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	@CPF
	private String cpf;
	
	public DisciplinaNewDTO() {}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
