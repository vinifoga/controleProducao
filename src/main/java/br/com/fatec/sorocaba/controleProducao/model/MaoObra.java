package br.com.fatec.sorocaba.controleProducao.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaoObra {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	private String descricao;	
	private String unidadeMedida;
	private LocalTime tempoTrabalho;

	public Long getCod() {
		return cod;
	}
	public void setCod(Long cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getUnidadeMedida() {
		return unidadeMedida;
	}
	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
	
	public LocalTime getTempoTrabalho() {
		return tempoTrabalho;
	}
	public void setTempoTrabalho(LocalTime tempoTrabalho) {
		this.tempoTrabalho = tempoTrabalho;
	}
	
}
