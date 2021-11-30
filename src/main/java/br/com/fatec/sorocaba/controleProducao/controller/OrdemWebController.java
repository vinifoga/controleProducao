package br.com.fatec.sorocaba.controleProducao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.sorocaba.controleProducao.model.Ordem;
import br.com.fatec.sorocaba.controleProducao.model.Produto;
import br.com.fatec.sorocaba.controleProducao.model.ProdutoOrdem;
import br.com.fatec.sorocaba.controleProducao.model.Usuario;
import br.com.fatec.sorocaba.controleProducao.service.OrdemService;
import br.com.fatec.sorocaba.controleProducao.service.ProdutoOrdemService;
import br.com.fatec.sorocaba.controleProducao.service.ProdutoService;
import br.com.fatec.sorocaba.controleProducao.service.UsuarioService;

@Controller
public class OrdemWebController {
	
	@Autowired
	private OrdemService ordemService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoOrdemService produtoOrdemService;
	
	@Autowired
	private UsuarioService usuarioService;
	

	@GetMapping("/ordem")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		ProdutoOrdem pf = new ProdutoOrdem();
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails usuario;
		usuario = ((UserDetails)principal);		
		modelAndView.addObject("usuario", usuario.getUsername());
		Usuario usuarioAtual = usuarioService.findByEmail(usuario.getUsername());
		
		pf.setOrdem(new Ordem());
		modelAndView.addObject("produtoOrdem", pf);		
		modelAndView.addObject("produtos", produtoService.list());
		List<Produto> list = produtoService.list();
		modelAndView.addObject("usuario", usuarioAtual);
		modelAndView.setViewName("ordem/index");
		return modelAndView;
	}
	
	@PostMapping("/ordem")
	public ModelAndView save(@Valid ProdutoOrdem produtoOrdem, @Valid Ordem ordem, @Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-ordem");
		if(ordem.getCodOp() == null) {
			ordemService.save(ordem);
		ProdutoOrdem produtoOrdemSalvo = produtoOrdemService.save(produtoOrdem, ordem);
		ordemService.gerarRequisicoes(produtoOrdemSalvo);
		produtoOrdemService.save(produtoOrdem, ordem);
		} else {
			ordemService.save(ordem);
			produtoOrdemService.save(produtoOrdem, ordem);
		}
		
		
//		try {
//			ordemService.save(ordem, ordem.getProdutoOrdem());
//		} catch (Exception e) {
//			mv.addObject("mensagemErro", "Não foi possível salvar ou editar esse usuário!");
//		}
//		attributes.addFlashAttribute("mensagemSucesso", "Ordem criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-ordem")
	public ModelAndView list() {
		List<ProdutoOrdem> ordens = produtoOrdemService.list();
		ModelAndView mv = new ModelAndView("ordem/list");
		mv.addObject("ordens", ordens);
		return mv;
	}	
	
	@GetMapping("ordem/editar/{codOp}")
	public ModelAndView faseProduto(@PathVariable("codOp") Long codOp, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		Ordem ordem = ordemService.findById(codOp);		
		
		ProdutoOrdem pf = produtoOrdemService.list().stream().filter(prodf -> prodf.getOrdem().equals(ordem)).findAny().get();
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetails usuario;
		usuario = ((UserDetails)principal);		
		modelAndView.addObject("usuario", usuario.getUsername());
		Usuario usuarioAtual = usuarioService.findByEmail(usuario.getUsername());

		modelAndView.addObject("produtoOrdem", pf);		
		modelAndView.addObject("produtos", produtoService.list());
		modelAndView.addObject("usuario", usuarioAtual);
		modelAndView.setViewName("ordem/index");
		return modelAndView;
		
	}
	
}
