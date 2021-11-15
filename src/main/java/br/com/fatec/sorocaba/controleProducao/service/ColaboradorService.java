package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Colaborador;
import br.com.fatec.sorocaba.controleProducao.repository.ColaboradorRepository;

@Service
public class ColaboradorService {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Transactional
	public Colaborador save(Colaborador colaborador) {
		return colaboradorRepository.saveAndFlush(colaborador);
	}
	
	public List<Colaborador> list(){
		return colaboradorRepository.findAll();
	}
	
	public Colaborador findById(Long id) {
		return colaboradorRepository.findById(id).get();
	}
}
