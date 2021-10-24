package br.com.fatec.sorocaba.controleProducao.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.sorocaba.controleProducao.model.Ordem;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoOrdem;
import br.com.fatec.sorocaba.controleProducao.service.OrdemService;
import br.com.fatec.sorocaba.controleProducao.service.ProdutoService;

@Controller
public class OrdemWebController {
	
	@Autowired
	private OrdemService ordemService;
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping("/ordem")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		ProdutoOrdem produtoOrdem = new ProdutoOrdem();
		Ordem ordem = new Ordem();
		ordem.setProdutoOrdem(produtoOrdem);
		modelAndView.addObject(ordem);		
		modelAndView.addObject("produtos", produtoService.list());
		modelAndView.setViewName("ordem/index");
		return modelAndView;
	}
	
	@PostMapping("/ordem")
	public ModelAndView save(@Valid Ordem ordem, BindingResult result, RedirectAttributes attributes) {
		System.out.println(LocalDateTime.now());
		ModelAndView mv = new ModelAndView("redirect:/lista-ordem");
		System.out.println(LocalDateTime.now());
		try {
			ordemService.save(ordem, ordem.getProdutoOrdem());
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar esse usuário!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Ordem criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-ordem")
	public ModelAndView list() {
		List<Ordem> ordens = ordemService.list();
		ModelAndView mv = new ModelAndView("ordem/list");
		mv.addObject("ordens", ordens);
		return mv;
	}	
	
}
