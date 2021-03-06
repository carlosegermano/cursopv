package com.carloseduardo.cursopv.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.carloseduardo.cursopv.domain.Aluno;
import com.carloseduardo.cursopv.services.validation.AlunoUpdate;

@AlunoUpdate
public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Campo de preenchimento obrigatório!")
	@Length(min=5, max=100, message="O tamanho deve ser entre 5 e 100")
	private String nome;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
