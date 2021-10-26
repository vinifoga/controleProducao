package br.com.fatec.sorocaba.controleProducao.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Equipamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codEq;
	private String descricao;
	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime tempoUso;

	public Long getCodEq() {
		return codEq;
	}

	public void setCodEq(Long codEq) {
		this.codEq = codEq;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalTime getTempoUso() {
		return tempoUso;
	}

	public void setTempoUso(LocalTime tempoUso) {
		this.tempoUso = tempoUso;
	}
	
	
}
