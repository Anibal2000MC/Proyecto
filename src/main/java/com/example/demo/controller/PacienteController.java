package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Paciente;
import com.example.demo.model.Usuario;
import com.example.demo.service.PacienteService;
import com.example.demo.service.UsuarioService;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/registro")
	public String showFormRegistro() {
		return "paciente-registro";
	}
	
	@PostMapping("/registro")
	public String registroPaciente(@RequestParam("nombres") String nombres,@RequestParam("apellidos") String apellidos,@RequestParam("edad") int edad,
			@RequestParam("nDocumento") int nDocumento,@RequestParam("nombreUsuario") String nombreUsuario,
			@RequestParam("contraseña") String contraseña) {
		
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.nombreUsuario = nombreUsuario;
		usuarioNuevo.contrasena = contraseña;
		
		usuarioService.createUsuario(usuarioNuevo);
		
		Usuario usuario = usuarioService.findByNombreUsuario(nombreUsuario);
		
		Paciente paciente = new Paciente();
		paciente.nombres = nombres;
		paciente.apellidos = apellidos;
		paciente.edad = edad;
		paciente.nDocumento = nDocumento;
		paciente.usuario = usuario;
		
		pacienteService.createPaciente(paciente);
		
		return "redirect:/login/login";
	}
}
