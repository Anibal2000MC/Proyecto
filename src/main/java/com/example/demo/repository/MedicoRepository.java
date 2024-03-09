package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Clinica;
import com.example.demo.model.Especialidad;
import com.example.demo.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{

	List<Medico> findByClinicaIdClinicaAndEspecialidadIdEspecialidad(Long idClinica, Long idEspecialidad);

}
