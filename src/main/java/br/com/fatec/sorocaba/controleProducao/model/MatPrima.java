package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatPrima {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMP;
	private String descricao;
	
	public Long getCodMP() {
		return codMP;
	}
	
	public void setCodMP(Long codMP) {
		this.codMP = codMP;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
