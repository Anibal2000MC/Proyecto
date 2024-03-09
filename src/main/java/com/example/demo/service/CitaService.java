package com.example.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Cita;
import com.example.demo.repository.CitaRepository;

@Service
public class CitaService {

	@Autowired
	private CitaRepository citaRepository;

	public List<Cita> getAllCitas() {
		return citaRepository.findAll();
	}

	public Cita getCitaById(Long id) {
		return citaRepository.findById(id).orElse(null);
	}

	public Cita createCita(Cita Cita) {
		return citaRepository.save(Cita);
	}

	public void deleteCita(Long id) {
		citaRepository.deleteById(id);
	}

	public List<Cita> encontrarCitasPorIdMedico(Long idMedico) {
		return citaRepository.findByMedicoIdMedico(idMedico);
	}
}
