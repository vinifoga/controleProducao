package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoOrdem;
import br.com.fatec.sorocaba.controleProducao.repository.ProdutoOrdemRepository;

@Service
public class ProdutoOrdemService {

	@Autowired
	private ProdutoOrdemRepository produtoOrdemRepository;
	
	@Transactional
	public ProdutoOrdem save(ProdutoOrdem produtoOrdem) {
		return produtoOrdemRepository.saveAndFlush(produtoOrdem);
	}

	public List<ProdutoOrdem> list() {
		return produtoOrdemRepository.findAll();
	}
	
}
