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

import br.com.fatec.sorocaba.controleProducao.model.MaoObra;
import br.com.fatec.sorocaba.controleProducao.service.MaoDeObraService;

@Controller
public class MaoDeObraWebController {
	
	@Autowired
	private MaoDeObraService maoDeObraService;

	@GetMapping("/mao-de-obra")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mao-de-obra", new MaoObra());
		modelAndView.setViewName("mao-de-obra/index");
		return modelAndView;
	}
	
	@PostMapping("/mao-de-obra")
	public ModelAndView save(@Valid MaoObra maoDeObra, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-mao-de-obra");
		
		try {
			maoDeObraService.save(maoDeObra);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-mao-de-obra")
	public ModelAndView list() {
		List<MaoObra> maosDeObra = maoDeObraService.list();
		ModelAndView mv = new ModelAndView("mao-de-obra/list");
		mv.addObject("maosDeObra", maosDeObra);
		return mv;
	}	
	
}
