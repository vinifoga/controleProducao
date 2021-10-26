package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.MatPrima;
import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.repository.MateriaPrimaRepository;

@Service
public class MateriaPrimaService {

	@Autowired
	private MateriaPrimaRepository materiaPrimaRepository;
	
	@Transactional
	public MatPrima save(MatPrima materiaPrima) {
		return materiaPrimaRepository.saveAndFlush(materiaPrima);
	}

	public List<MatPrima> list() {
		return materiaPrimaRepository.findAll();
	}
	
}
