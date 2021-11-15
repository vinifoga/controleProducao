package br.com.fatec.sorocaba.controleProducao.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ProdutoFaseMat {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdFaseMat;
	private Integer qtdeMP;
	@ManyToOne
	private ProdutoFase produtoFase;
	@OneToMany(mappedBy="produtoFaseMatPrima", cascade=CascadeType.ALL)
	private List<MatPrima> matPrima;
	@OneToMany(mappedBy="produtoFaseMatPrima", cascade=CascadeType.ALL)
	private List<MatPrimaReq> matPrimaReq;
	
	
	public Long getCodProdFaseMat() {
		return codProdFaseMat;
	}
	public void setCodProdFaseMat(Long codProdFaseMat) {
		this.codProdFaseMat = codProdFaseMat;
	}
	public Integer getQtdeMP() {
		return qtdeMP;
	}
	public void setQtdeMP(Integer qtdeMP) {
		this.qtdeMP = qtdeMP;
	}
	public ProdutoFase getProdutoFase() {
		return produtoFase;
	}
	public void setProdutoFase(ProdutoFase produtoFase) {
		this.produtoFase = produtoFase;
	}
	
	public List<MatPrima> getMatPrima() {
		return matPrima;
	}
	public void setMatPrima(List<MatPrima> matPrima) {
		this.matPrima = matPrima;
	}
	
	public List<MatPrimaReq> getMatPrimaReq() {
		return matPrimaReq;
	}
	public void setMatPrimaReq(List<MatPrimaReq> matPrimaReq) {
		this.matPrimaReq = matPrimaReq;
	}
	
	
	
}
