package br.com.fatec.sorocaba.controleProducao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.sorocaba.controleProducao.model.MaoObra;

@Repository
public interface MaoDeObraRepository extends JpaRepository<MaoObra, Long>{

}
