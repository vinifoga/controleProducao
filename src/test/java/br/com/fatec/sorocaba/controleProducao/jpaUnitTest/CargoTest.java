package br.com.fatec.sorocaba.controleProducao.jpaUnitTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.fatec.sorocaba.controleProducao.model.Cargo;
import br.com.fatec.sorocaba.controleProducao.service.CargoService;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
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
