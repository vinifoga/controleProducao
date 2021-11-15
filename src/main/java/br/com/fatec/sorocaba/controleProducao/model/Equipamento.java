package br.com.fatec.sorocaba.controleProducao.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Equipamento {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cod;
	private String descricao;	
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime tempoUso;
	@ManyToOne
	private ProdutoFaseEquipamento produtoFaseEquipamento;
	

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

	public LocalTime getTempoUso() {
		return tempoUso;
	}

	public void setTempoUso(LocalTime tempoUso) {
		this.tempoUso = tempoUso;
	}
	
	public ProdutoFaseEquipamento getProdutoFaseEquipamento() {
		return produtoFaseEquipamento;
	}
	
	public void setProdutoFaseEquipamento(ProdutoFaseEquipamento produtoFaseEquipamento) {
		this.produtoFaseEquipamento = produtoFaseEquipamento;
	}
	
}
