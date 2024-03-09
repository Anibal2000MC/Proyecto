package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Especialidad;
import com.example.demo.model.Medico;
import com.example.demo.model.Clinica;
import com.example.demo.service.ClinicaService;
import com.example.demo.service.EspecialidadService;
import com.example.demo.service.MedicoService;

import ch.qos.logback.core.subst.Token;

@Controller
@RequestMapping("/medicos")
public class MedicoController {
	
	@Autowired
	private ClinicaService clinicaService;
	
	@Autowired
	private EspecialidadService especialidadService;
	
	@Autowired
	private MedicoService medicoService;


	  @GetMapping("/buscar")
	    public String buscarMedicosPorClinicaYEspecialidad(@RequestParam Long idClinica, @RequestParam Long idEspecialidad, Model model) {
			model.addAttribute("clinicas", clinicaService.getAllClinicas());
			model.addAttribute("especialidades", especialidadService.getAllEspecialidades());
			 
	        List<Medico> medicos = medicoService.buscarMedicosPorClinicaYEspecialidad(idClinica, idEspecialidad);
	        model.addAttribute("medicos", medicos);
	        if (medicos.isEmpty()) {
				return "redirect:/citas/medicos?sinResultados=true";
			}
	        model.addAttribute("busquedaRealizada", !medicos.isEmpty());

	        return "medicos";	   
	        }
}
