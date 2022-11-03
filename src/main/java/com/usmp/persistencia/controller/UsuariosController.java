package com.usmp.persistencia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usmp.persistencia.models.Usuario;
import com.usmp.persistencia.service.IUsuariosService;

@Controller
@RequestMapping(value="/usuarios")
public class UsuariosController {

	@Autowired
	private IUsuariosService serviceUsuario;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model){
		List<Usuario> lista = serviceUsuario.buscarTodas();
	    model.addAttribute("usuarios", lista);
	    return"usuarios/listUsuarios";
	}
	
	@GetMapping("/create")
	public String crear(Usuario usuario){
	    return"usuarios/formUsuario";
	}
	
	@PostMapping("/save")
	public String guardar(Usuario usuario, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()) {
			for(ObjectError error:result.getAllErrors()){
				   System.out.println("Ocurrio un error: " + error.getDefaultMessage());
			}
			return"usuarios/formUsuario";
		}
		serviceUsuario.guardar(usuario);
		attributes.addFlashAttribute("msg","Registro Guardado");
		System.out.println("Usuario: " + usuario);
		return"redirect:/usuarios/index";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarUsu(@PathVariable("id") Long idUsuario, RedirectAttributes attributes) {
		System.out.println("Codigo eliminado es: " + idUsuario);
		serviceUsuario.eliminar(idUsuario);
		attributes.addFlashAttribute("msg", "Registro Eliminado");
		return"redirect:/usuarios/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") Long idUsuario, Model model){
		Usuario usuario = serviceUsuario.buscarPorId(idUsuario);
	    model.addAttribute("usuario", usuario);
	    return"usuarios/formUsuario";
	}
	
}
