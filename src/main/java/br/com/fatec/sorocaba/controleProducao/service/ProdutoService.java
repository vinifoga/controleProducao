package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Transactional
	public Produto save(Produto produto) {
		return produtoRepository.saveAndFlush(produto);
	}

	public List<Produto> list() {
		return produtoRepository.findAll();
	}
	
	public Produto findById(Long id) {
		return produtoRepository.findById(id).get();
	}
	
	public void delete(Produto produto) {
		produtoRepository.delete(produto);
	}
	
}
