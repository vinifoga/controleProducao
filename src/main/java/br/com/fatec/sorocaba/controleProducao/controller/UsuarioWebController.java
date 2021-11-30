package br.com.fatec.sorocaba.controleProducao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fatec.sorocaba.controleProducao.model.Colaborador;
import br.com.fatec.sorocaba.controleProducao.model.Usuario;
import br.com.fatec.sorocaba.controleProducao.service.CargoService;
import br.com.fatec.sorocaba.controleProducao.service.ColaboradorService;
import br.com.fatec.sorocaba.controleProducao.service.RoleService;
import br.com.fatec.sorocaba.controleProducao.service.UsuarioService;

@Controller
public class UsuarioWebController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ColaboradorService colaboradorService;
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private RoleService roleService;
	

	@GetMapping("/usuario")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("usuario/index");
		return modelAndView;
	}
	
	@GetMapping("/usuario/addUsuario/{matricula}")
	public ModelAndView novoRecurso(@PathVariable("matricula") Long matricula, HttpServletRequest request, HttpServletResponse response) {
		Colaborador colaborador = colaboradorService.findById(matricula);	
		ModelAndView modelAndView = new ModelAndView();
		Usuario usuario = new Usuario();
		usuario.setNome(colaborador.getNome());
		usuario.setColaborador(colaborador);
		colaborador.setUsuario(usuario);
		modelAndView.addObject("colaborador", colaborador);
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("usuario/colaborador");
		return modelAndView;
	}

	@PostMapping("/usuario")
	public ModelAndView save(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/lista-usuario");
		if(colaboradorService.list().stream().filter(c -> c.getMatricula().equals(usuario.getColaborador().getMatricula())).findAny().get().getCargo()==cargoService.findById(1L)) {
			usuario.setRoles(roleService.list().stream().filter(rl -> rl.getNomeRole().compareTo("ROLE_LIDER")==0).collect(Collectors.toList()));
		}else if(colaboradorService.list().stream().filter(c -> c.getMatricula().equals(usuario.getColaborador().getMatricula())).findAny().get().getCargo()==cargoService.findById(2L)) {
			usuario.setRoles(roleService.list().stream().filter(rl -> rl.getNomeRole()=="ROLE_OPERADOR").collect(Collectors.toList()));
		}
		
		try {
			Colaborador colaborador = colaboradorService.findById(usuario.getColaborador().getMatricula());
			usuario.setColaborador(colaborador);
			usuarioService.save(usuario);
		} catch (Exception e) {
			mv.addObject("mensagemErro", "Não foi possível salvar ou editar esse usuário!");
		}
		attributes.addFlashAttribute("mensagemSucesso", "Usuário criado ou alterado com sucesso!");
		return mv;
	}
	
	@GetMapping("/lista-usuario")
	public ModelAndView list() {
		List<Usuario> usuarios = usuarioService.list();
		ModelAndView mv = new ModelAndView("usuario/list");
		mv.addObject("usuarios", usuarios);
		return mv;
	}	
	
	@GetMapping("/edita-usuario/{id}")
	public ModelAndView editaUsuario(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		Usuario usuario = usuarioService.findById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("usuario", usuario);
		modelAndView.setViewName("usuario/colaborador");
		return modelAndView;
	}
	
	@GetMapping("/usuario/excluir/{id}")
	public ModelAndView deletaUsuario(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) {
		usuarioService.delete(usuarioService.findById(id));
		ModelAndView modelAndView = new ModelAndView();
		List<Usuario> usuarios = usuarioService.list();
		modelAndView.addObject("usuarios", usuarios);
		modelAndView.setViewName("redirect:/lista-usuario");
		return modelAndView;
	}
}
