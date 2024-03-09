package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}

	@PostMapping("/login")
	public String login(String usuario, String contraseña, RedirectAttributes redirectAttributes,HttpServletRequest request) {

		Usuario usuarioBase = usuarioService.findByNombreUsuario(usuario);

		if (usuarioBase != null && usuarioBase.getContrasena().equals(contraseña)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			return "redirect:/citas/cita";
		} else {
			
			return "redirect:/login/login?error=true";
		}
	}

	@GetMapping("/home")
	public String homePage() {

		return "home";
	}

}
