package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProduto;
	private String descProduto;
	@Enumerated(EnumType.STRING)
	private Corte corte;
	@Enumerated(EnumType.STRING)
	private Tempero tempero;
	@Enumerated(EnumType.STRING)
	private Embalagem embalagem;
	
	public Long getCodProduto() {
		return codProduto;
	}
	
	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}
	
	public String getDescProduto() {
		return descProduto;
	}
	
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	
	public Corte getCorte() {
		return corte;
	}
	
	public void setCorte(Corte corte) {
		this.corte = corte;
	}
	
	public Tempero getTempero() {
		return tempero;
	}
	
	public void setTempero(Tempero tempero) {
		this.tempero = tempero;
	}
	
	public Embalagem getEmbalagem() {
		return embalagem;
	}
	
	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}
}
