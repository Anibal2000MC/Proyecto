package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Clinica;
import com.example.demo.repository.ClinicaRepository;

@Service
public class ClinicaService {

	@Autowired
	private ClinicaRepository clinicaRepository;
	
	public List<Clinica> getAllClinicas(){
		return clinicaRepository.findAll();
	}
	
	public Clinica getClinicaById(Long id) {
		return clinicaRepository.findById(id).orElse(null);
	}
}
