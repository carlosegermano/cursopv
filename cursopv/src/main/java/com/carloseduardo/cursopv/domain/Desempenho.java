package com.carloseduardo.cursopv.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Desempenho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double linguaPortuguesa;
	private double matematica;
	private double historia;
	private double geografia;
	private double fisica;
	private double quimica;
	private double biologia;
	private double sociologia;
	private double filosofia;
	private double linguaEspanhola;
	private double mediaGeral;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="aluno_id")
	private Aluno aluno;
	
	public Desempenho() {
	}

	public Desempenho(Integer id, double linguaPortuguesa, double matematica, double historia, double geografia,
			double fisica, double quimica, double biologia, double sociologia, double filosofia, double linguaEspanhola,
			double mediaGeral, Aluno aluno) {
		super();
		this.id = id;
		this.linguaPortuguesa = linguaPortuguesa;
		this.matematica = matematica;
		this.historia = historia;
		this.geografia = geografia;
		this.fisica = fisica;
		this.quimica = quimica;
		this.biologia = biologia;
		this.sociologia = sociologia;
		this.filosofia = filosofia;
		this.linguaEspanhola = linguaEspanhola;
		this.mediaGeral = mediaGeral;
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getLinguaPortuguesa() {
		return linguaPortuguesa;
	}

	public void setLinguaPortuguesa(double linguaPortuguesa) {
		this.linguaPortuguesa = linguaPortuguesa;
	}

	public double getMatematica() {
		return matematica;
	}

	public void setMatematica(double matematica) {
		this.matematica = matematica;
	}

	public double getHistoria() {
		return historia;
	}

	public void setHistoria(double historia) {
		this.historia = historia;
	}

	public double getGeografia() {
		return geografia;
	}

	public void setGeografia(double geografia) {
		this.geografia = geografia;
	}

	public double getFisica() {
		return fisica;
	}

	public void setFisica(double fisica) {
		this.fisica = fisica;
	}

	public double getQuimica() {
		return quimica;
	}

	public void setQuimica(double quimica) {
		this.quimica = quimica;
	}

	public double getBiologia() {
		return biologia;
	}

	public void setBiologia(double biologia) {
		this.biologia = biologia;
	}

	public double getSociologia() {
		return sociologia;
	}

	public void setSociologia(double sociologia) {
		this.sociologia = sociologia;
	}

	public double getFilosofia() {
		return filosofia;
	}

	public void setFilosofia(double filosofia) {
		this.filosofia = filosofia;
	}

	public double getLinguaEspanhola() {
		return linguaEspanhola;
	}

	public void setLinguaEspanhola(double linguaEspanhola) {
		this.linguaEspanhola = linguaEspanhola;
	}

	public double getMediaGeral() {
		return mediaGeral;
	}

	public void setMediaGeral(double mediaGeral) {
		this.mediaGeral = mediaGeral;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
}
