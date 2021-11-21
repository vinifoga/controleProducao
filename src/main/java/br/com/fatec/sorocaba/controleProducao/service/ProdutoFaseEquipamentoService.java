package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.ProdutoFaseEquipamento;
import br.com.fatec.sorocaba.controleProducao.repository.ProdutoFaseEquipamentoRepository;

@Service
public class ProdutoFaseEquipamentoService {

	@Autowired
	private ProdutoFaseEquipamentoRepository produtoFaseEquipamentoRepository;
	
	@Transactional
	public ProdutoFaseEquipamento save(ProdutoFaseEquipamento produtoFaseEquipamento) {
		return produtoFaseEquipamentoRepository.saveAndFlush(produtoFaseEquipamento);
	}
	
	public List<ProdutoFaseEquipamento> list(){
		return produtoFaseEquipamentoRepository.findAll();
	}
	
	
}
