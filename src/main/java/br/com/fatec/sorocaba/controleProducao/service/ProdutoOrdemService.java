package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Ordem;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoOrdem;
import br.com.fatec.sorocaba.controleProducao.repository.ProdutoOrdemRepository;

@Service
public class ProdutoOrdemService {

	@Autowired
	private ProdutoOrdemRepository produtoOrdemRepository;
	
	@Autowired
	private OrdemService ordemService;
	
	@Transactional
	public ProdutoOrdem save(ProdutoOrdem produtoOrdem, Ordem ordem) {
		Ordem ordemSalva = ordemService.save(ordem);
		produtoOrdem.setOrdem(ordemSalva);
		return produtoOrdemRepository.saveAndFlush(produtoOrdem);
	}

	public List<ProdutoOrdem> list() {
		return produtoOrdemRepository.findAll();
	}
	
}
