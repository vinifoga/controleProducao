package br.com.fatec.sorocaba.controleProducao.jpaUnitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.fatec.sorocaba.controleProducao.model.Cargo;
import br.com.fatec.sorocaba.controleProducao.service.CargoService;

@DataJpaTest
@ActiveProfiles("test")
public class CargoTest {

	@Autowired
	CargoService cargoService;
	
	@Test
	public void testaSeSalvaCargo() {
		Cargo cargo = new Cargo("Líder");
		Cargo cargoSalvo = cargoService.save(cargo);
		assertThat(cargoSalvo).usingRecursiveComparison().ignoringFields("id").isEqualTo(cargo);
		
	}
	
}
