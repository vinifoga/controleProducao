package br.com.fatec.sorocaba.controleProducao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	@OneToMany(mappedBy = "produto", cascade=CascadeType.ALL)
	private List<ProdutoFase> produtosFase;
	@OneToMany(mappedBy = "produto", cascade=CascadeType.ALL)
	private List<ProdutoOrdem> produtoOrdem;
	
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
	
	public List<ProdutoFase> getProdutosFase() {
		return produtosFase;
	}
	public void setProdutosFase(List<ProdutoFase> produtosFase) {
		this.produtosFase = produtosFase;
	}
	
	public List<ProdutoOrdem> getProdutoOrdem() {
		return produtoOrdem;
	}
	public void setProdutoOrdem(List<ProdutoOrdem> produtoOrdem) {
		this.produtoOrdem = produtoOrdem;
	}
}
