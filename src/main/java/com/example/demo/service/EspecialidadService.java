package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Especialidad;
import com.example.demo.repository.EspecialidadRepository;

@Service
public class EspecialidadService {

	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	public List<Especialidad> getAllEspecialidades(){
		return especialidadRepository.findAll();
	}
	
	public Especialidad getEspecialidadById(Long id) {
		return especialidadRepository.findById(id).orElse(null);
	}
}
