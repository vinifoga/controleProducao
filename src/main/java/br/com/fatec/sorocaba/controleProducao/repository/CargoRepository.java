package br.com.fatec.sorocaba.controleProducao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.sorocaba.controleProducao.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
	
	Optional<Cargo> findById(Long id);

}
