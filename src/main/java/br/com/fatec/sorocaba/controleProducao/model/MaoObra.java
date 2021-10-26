package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MaoObra {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codMO;
	private String descricao;
	private String unidadeMedida;
	
	public Long getCodMO() {
		return codMO;
	}
	public void setCodMO(Long codMO) {
		this.codMO = codMO;
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

	
}
