package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Clinica;
import com.example.demo.model.Especialidad;
import com.example.demo.model.Medico;
import com.example.demo.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	public MedicoRepository medicoRepository;
	
	public List<Medico> getAllMedicos(){
		return medicoRepository.findAll();
	}
	public Medico getMedicoById(Long id) {
		return medicoRepository.findById(id).orElse(null);
	}
	
	 public List<Medico> buscarMedicosPorClinicaYEspecialidad(Long idClinica, Long idEspecialidad) {
	        return medicoRepository.findByClinicaIdClinicaAndEspecialidadIdEspecialidad(idClinica, idEspecialidad);
	    }
}
