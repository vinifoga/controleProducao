package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Fase;
import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFase;
import br.com.fatec.sorocaba.controleProducao.repository.ProdutoFaseRepository;

@Service
public class ProdutoFaseService {

	@Autowired
	private ProdutoFaseRepository produtoFaseRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FaseService faseService;
	
	@Transactional
	public ProdutoFase save(ProdutoFase produtoFase, Produto produto, Fase fase) {
		produtoService.save(produto);
		faseService.save(fase);
		return produtoFaseRepository.saveAndFlush(produtoFase);
	}
	
	public List<ProdutoFase> list(){
		return produtoFaseRepository.findAll();
	}
	
	public ProdutoFase findById(Long id) {
		return produtoFaseRepository.findById(id).get();
	}
	
	public List<ProdutoFase> findByProduto(Produto produto){
		return produtoFaseRepository.findByProduto(produto);
	}
}
