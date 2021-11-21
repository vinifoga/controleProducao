package br.com.fatec.sorocaba.controleProducao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.sorocaba.controleProducao.model.MatPrimaReq;

@Repository
public interface MatPrimaReqRepository extends JpaRepository<MatPrimaReq, Long>{

}
