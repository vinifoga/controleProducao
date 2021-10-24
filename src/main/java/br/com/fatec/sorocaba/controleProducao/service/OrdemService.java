package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Ordem;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoOrdem;
import br.com.fatec.sorocaba.controleProducao.repository.OrdemRepository;
import br.com.fatec.sorocaba.controleProducao.repository.ProdutoOrdemRepository;

@Service
public class OrdemService {

	@Autowired
	private OrdemRepository ordemRepository;
	
	@Autowired
	private ProdutoOrdemRepository produtoOrdemRepository;
	
	@Transactional
	public Ordem save(Ordem ordem, ProdutoOrdem produtoOrdem) {
		produtoOrdemRepository.saveAndFlush(produtoOrdem);
		return ordemRepository.saveAndFlush(ordem);
	}

	public List<Ordem> list() {
		return ordemRepository.findAll();
	}
	
}
