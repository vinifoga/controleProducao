package br.com.fatec.sorocaba.controleProducao.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ProdutoFaseMat {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProdFaseMat;
	private Double qtdeMP;
	@ManyToOne
	private ProdutoFase produtoFase;
	@OneToOne
	private MatPrima matPrima;
	@OneToOne(mappedBy="produtoFaseMatPrima", cascade=CascadeType.ALL)
	private MatPrimaReq matPrimaReq;
	
	
	public Long getCodProdFaseMat() {
		return codProdFaseMat;
	}
	public void setCodProdFaseMat(Long codProdFaseMat) {
		this.codProdFaseMat = codProdFaseMat;
	}
	public Double getQtdeMP() {
		return qtdeMP;
	}
	public void setQtdeMP(Double qtdeMP) {
		this.qtdeMP = qtdeMP;
	}
	public ProdutoFase getProdutoFase() {
		return produtoFase;
	}
	public void setProdutoFase(ProdutoFase produtoFase) {
		this.produtoFase = produtoFase;
	}
	
	public MatPrima getMatPrima() {
		return matPrima;
	}
	public void setMatPrima(MatPrima matPrima) {
		this.matPrima = matPrima;
	}
	
	public MatPrimaReq getMatPrimaReq() {
		return matPrimaReq;
	}
	public void setMatPrimaReq(MatPrimaReq matPrimaReq) {
		this.matPrimaReq = matPrimaReq;
	}
	
	
	
}
