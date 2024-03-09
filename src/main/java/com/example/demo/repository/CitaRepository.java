package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long>{

	List<Cita> findByMedicoIdMedico(Long idMedico);
}
