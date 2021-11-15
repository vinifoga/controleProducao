package br.com.fatec.sorocaba.controleProducao.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.sorocaba.controleProducao.model.Cargo;
import br.com.fatec.sorocaba.controleProducao.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Transactional
	public Cargo save(Cargo cargo) {
		return cargoRepository.saveAndFlush(cargo);
	}
	
	public List<Cargo> list(){
		return cargoRepository.findAll();
	}
}
