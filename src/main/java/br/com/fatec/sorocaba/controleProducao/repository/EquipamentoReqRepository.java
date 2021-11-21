package br.com.fatec.sorocaba.controleProducao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.sorocaba.controleProducao.model.EquipamentoReq;

@Repository
public interface EquipamentoReqRepository extends JpaRepository<EquipamentoReq, Long>{

}
