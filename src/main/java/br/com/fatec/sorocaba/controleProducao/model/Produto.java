package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProduto;
	private String descProduto;
	private Corte corte;
	private Tempero tempero;
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
	
	@Column(columnDefinition="ENUM('LISA','ONDULADA')")
	public Corte getCorte() {
		return corte;
	}
	
	public void setCorte(Corte corte) {
		this.corte = corte;
	}
	
	@Column(columnDefinition="ENUM('FRANGO_GRELHADO','MOSTARDA','TRADICIONAL','CHURRASCO','CEBOLA_E_SALSA','COSTELINHA_COM_LIMAO','PIMENTA_MEXICANA')")
	public Tempero getTempero() {
		return tempero;
	}
	
	public void setTempero(Tempero tempero) {
		this.tempero = tempero;
	}
	
	@Column(columnDefinition="ENUM('G17','G22','G30','G40','G57','G60','G92','G100','G167','G300')")
	public Embalagem getEmbalagem() {
		return embalagem;
	}
	
	public void setEmbalagem(Embalagem embalagem) {
		this.embalagem = embalagem;
	}
}
