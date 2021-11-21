package br.com.fatec.sorocaba.controleProducao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.sorocaba.controleProducao.model.Fase;
import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoFase;

@Repository
public interface ProdutoFaseRepository extends JpaRepository<ProdutoFase, Long>{
	
	List<ProdutoFase> findByProduto(Produto produto);
	
	List<ProdutoFase> findByFase(Fase fase);

}
