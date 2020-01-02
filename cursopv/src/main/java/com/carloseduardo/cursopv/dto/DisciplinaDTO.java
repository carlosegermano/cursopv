package com.carloseduardo.cursopv.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.carloseduardo.cursopv.domain.Disciplina;

public class DisciplinaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	@Length(min=6, max=6, message="O código deve ter 6 dígitos!")
	private String codigo;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	@Length(min=5, max=100, message="O tamanho deve ser entre 5 e 100")
	private String nome;
	
	public DisciplinaDTO() {}

	public Integer getId() {
		return id;
	}
	
	public DisciplinaDTO(Disciplina obj) {
		this.id = obj.getId();
		this.codigo = obj.getCodigo();
		this.nome = obj.getNome();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
