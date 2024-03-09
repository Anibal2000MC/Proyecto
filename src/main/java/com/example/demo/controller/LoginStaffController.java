package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/staff")
public class LoginStaffController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String showLoginForm() {
		return "login-staff";
	}
	
	@PostMapping("/login")
	public String login(String usuario, String contraseña, RedirectAttributes redirectAttributes,HttpServletRequest request) {

		Usuario usuarioBase = usuarioService.findByNombreUsuario(usuario);

		if (usuarioBase != null && usuarioBase.getContrasena().equals(contraseña)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			return "redirect:/report/reporte-citas";
		} else {
			
			return "redirect:/staff/login?error=true";
		}
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
	    // Invalida la sesión actual
	    session.invalidate();
	    
	    // Redirige al usuario a la página de inicio o a donde desees después de cerrar sesión
	    return "redirect:/home";
	}
}
