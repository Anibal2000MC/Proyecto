package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.PacienteRepository;
import com.example.demo.model.Paciente;

@Service
public class PacienteService {

	@Autowired
	public PacienteRepository pacienteRepository;
	
	public List<Paciente> getAllPacientes(){
		return pacienteRepository.findAll();
	}
	
	public Paciente getPacienteById(Long id) {
		return pacienteRepository.findById(id).orElse(null);
	}
	
	public Paciente getPacienteByUsusario_NombreUsuario(String nombreUsuario) {
		return pacienteRepository.findByUsuario_NombreUsuario(nombreUsuario);
	};
	
	public Paciente createPaciente(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}
	
	public void deletePaciente(Long id) {
		pacienteRepository.deleteById(id);
	}
}
