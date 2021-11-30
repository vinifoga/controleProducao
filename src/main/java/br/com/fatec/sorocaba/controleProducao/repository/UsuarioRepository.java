package br.com.fatec.sorocaba.controleProducao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatec.sorocaba.controleProducao.model.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail(String email);

//	update usuario set email = 'vinicius.fogaca@denisico.com.br', nome = 'Vinicius Fernandes Fogaça' where id = 2;

	@Modifying
	@Query(value ="update usuario set"
			+ "email = :email"
    		+ "where id = :id",nativeQuery = true)
    int updateUsuario(Long id, String email);
	
}
