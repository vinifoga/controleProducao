package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Fase;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFase;
import br.com.fatec.sorocaba.controleProducao.repository.FaseRepository;

@Service
public class FaseService {

	@Autowired
	private FaseRepository faseRepository;
	
	@Autowired
	private ProdutoFaseService produtoFaseService;
	
	@Transactional
	public Fase save(Fase fase) {
		return faseRepository.saveAndFlush(fase);
	}

	public List<Fase> list() {
		return faseRepository.findAll();
	}
	
	public Optional<Fase> findById(Long id) {
		return faseRepository.findById(id);
	}
	
}
