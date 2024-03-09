package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.RegistroAtencion;
import com.example.demo.repository.ReporteRepository;

@Service
public class RegistroService {

	@Autowired
	private ReporteRepository registroepository;
	
	public List<RegistroAtencion> getAllRegistros(){
		return registroepository.findAll();
	}
	
	public RegistroAtencion getRegistroById(Long id) {
		return registroepository.findById(id).orElse(null);
	}
	
	public RegistroAtencion createRegistro(RegistroAtencion registro) {
		return registroepository.save(registro);
	}
	
	public void deleteRegistro(Long id) {
		registroepository.deleteById(id);
	}
}
