package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Cita;
import com.example.demo.model.Medico;
import com.example.demo.model.Paciente;
import com.example.demo.service.CitaService;
import com.example.demo.service.ClinicaService;
import com.example.demo.service.EspecialidadService;
import com.example.demo.service.MedicoService;
import com.example.demo.service.PacienteService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/citas")
public class CitasController {

	@Autowired
	private CitaService citaService;

	@Autowired
	private ClinicaService clinicaService;

	@Autowired
	private MedicoService medicoService;

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private EspecialidadService especialidadService;
	
	public List<Medico> medicosByCYE;
	
	@GetMapping("cita")
	public String showCitas( Model model) {
		model.addAttribute("clinicas", clinicaService.getAllClinicas());
		model.addAttribute("especialidades", especialidadService.getAllEspecialidades());
		
		return "citas";
	}

	@GetMapping("/clinicas")
	public String showClinicas() {
		return "clinicas";
	}

	@GetMapping("/medicos")
	public String showMedicos(Model model) {
		model.addAttribute("clinicas", clinicaService.getAllClinicas());
		model.addAttribute("especialidades", especialidadService.getAllEspecialidades());
		return "medicos";
	}

	@GetMapping("/contactanos")
	public String showContactanos(Model model) {
		model.addAttribute("clinicas", clinicaService.getAllClinicas());
		return "contactanos";
	}

	@GetMapping("pide-tu-cita")
	public String showPideTuCita(@RequestParam("idClinica") Long idClinica,@RequestParam("idEspecialidad") Long idEspecialidad,
			Model model,HttpSession session) {
		List<Medico> medicos = medicoService.buscarMedicosPorClinicaYEspecialidad(idClinica, idEspecialidad);
		model.addAttribute("medicos", medicos);
		
		if (medicos.isEmpty()) {
			return "redirect:/citas/cita?sinResultados=true";
		}
		if (session.getAttribute("usuario") == null) {
			return "redirect:/login/login";
		}
		return "pide-tu-cita";
	}

	@PostMapping("crear-cita")
	public String crearCita(@RequestParam("dia") String dia, @RequestParam("hora") String hora,
			@RequestParam("idMedico") Long idMedico, Model model, HttpSession session) {

		String nombrePaciente = (String) session.getAttribute("usuario");

		LocalDate fechaCita = LocalDate.parse(dia);
		LocalTime horaCita = LocalTime.parse(hora);

		Cita cita = new Cita();
		cita.dia = fechaCita;
		cita.hora = horaCita;

		Medico medico = medicoService.getMedicoById(idMedico);
		Paciente paciente = pacienteService.getPacienteByUsusario_NombreUsuario(nombrePaciente);
		
		cita.medico = medico;
		cita.paciente = paciente;
		citaService.createCita(cita);
		
		return "citas";
	}

}
