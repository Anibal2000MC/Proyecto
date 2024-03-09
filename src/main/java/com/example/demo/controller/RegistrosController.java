package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.RegistroAtencion;
import com.example.demo.service.RegistroService;

@Controller
@RequestMapping("/registros")
public class RegistrosController {
	
	@Autowired
	private RegistroService registroService;
	
	
	@PostMapping("/crearRegistro")
	public String createProduct(@RequestParam("nombres") String nombres, 
			@RequestParam("apellidos") String apellidos, @RequestParam("clinica") String clinica, @RequestParam("email") String email, 
			@RequestParam("celular") int celular,@RequestParam("motivo") String motivo,@RequestParam("consulta") String consulta, Model model) {
		
		RegistroAtencion registroAtencion = new RegistroAtencion();
		registroAtencion.nombres = nombres;
		registroAtencion.apellidos = apellidos;
		registroAtencion.clinica = clinica;
		registroAtencion.email = email;
		registroAtencion.celular = celular;
		registroAtencion.motivo = motivo;
		registroAtencion.consulta = consulta;
		
	
		registroService.createRegistro(registroAtencion);
		
		model.addAttribute("registros", registroService.getAllRegistros());
		
		return "redirect:/citas/contactanos";
	}
	
	@GetMapping("/listRegistros")
	public String getAllRegistros(Model model) {

		List<RegistroAtencion> listRegistros = registroService.getAllRegistros();

		model.addAttribute("registroAtencions", listRegistros);

		return "lista-registros";
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteRegistro(@PathVariable Long id, Model model) {
		registroService.deleteRegistro(id);
		List<RegistroAtencion> listRegistros = registroService.getAllRegistros();
		model.addAttribute("registroAtencions", listRegistros);
		
		return "/lista-registros";
	}
}