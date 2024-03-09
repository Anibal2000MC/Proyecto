package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {
	
	@GetMapping("home")
	public String showHome() {
		return "home";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
	    // Invalida la sesión actual
	    session.invalidate();
	    
	    // Redirige al usuario a la página de inicio o a donde desees después de cerrar sesión
	    return "redirect:/home";
	}

}
