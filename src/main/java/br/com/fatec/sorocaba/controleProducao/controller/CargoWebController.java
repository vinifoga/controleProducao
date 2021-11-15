package br.com.fatec.sorocaba.controleProducao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.sorocaba.controleProducao.model.Cargo;
import br.com.fatec.sorocaba.controleProducao.model.Usuario;
import br.com.fatec.sorocaba.controleProducao.service.CargoService;

@Controller
public class CargoWebController {

	@Autowired
	private CargoService cargoService;
	

	@GetMapping("/cargo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("cargo", new Cargo());
		modelAndView.setViewName("cargo/index");
		return modelAndView;
	}
	
	@PostMapping("/cargo")
	public ModelAndView save(@Valid Cargo cargo, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-cargo");
		
		try {
			cargoService.save(cargo);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-cargo")
	public ModelAndView list() {
		List<Cargo> cargos = cargoService.list();
		ModelAndView mv = new ModelAndView("cargo/list");
		mv.addObject("cargos", cargos);
		return mv;
	}	

}
