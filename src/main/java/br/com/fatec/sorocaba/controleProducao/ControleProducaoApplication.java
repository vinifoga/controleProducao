package br.com.fatec.sorocaba.controleProducao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class ControleProducaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleProducaoApplication.class, args);
	}
	
	

}
