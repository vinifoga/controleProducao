package br.com.fatec.sorocaba.controleProducao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.sorocaba.controleProducao.service.ProdutoService;

@Controller
public class RelatorioWebController {
	
	@Autowired
	private ProdutoService produtoService;	

	@GetMapping("/relatorio")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("produtos", produtoService.list());
		modelAndView.setViewName("relatorio/index");
		return modelAndView;
	}
	
	@GetMapping("/relatorio/produto")
	public ModelAndView produto() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("produtos", produtoService.list());
		modelAndView.setViewName("relatorio/produto");
		return modelAndView;
	}
	
	@GetMapping("/relatorio/status")
	public ModelAndView status() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("produtos", produtoService.list());
		modelAndView.setViewName("relatorio/status");
		return modelAndView;
	}
	
	@PostMapping("/relatorio")
	public ModelAndView save() {
		return null;
	}

}
