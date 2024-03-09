package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="cita")
public class Cita {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idCita;

	@Column(name = "hora")
	public LocalTime hora;
	
	@Column(name = "dia")
	public LocalDate dia;

	@ManyToOne
    @JoinColumn(name="idPaciente", nullable=false)
    public Paciente paciente;
	
	@ManyToOne
    @JoinColumn(name="idMedico", nullable=false)
    public Medico medico;
	
	@Transient
	public String nombrePaciente ;
	
	@Transient
	public String nombreMedico ;

	
	public Cita(Long idCita, LocalTime hora, LocalDate dia, Paciente paciente, Medico medico, String nombrePaciente,
			String nombreMedico) {
		super();
		this.idCita = idCita;
		this.hora = hora;
		this.dia = dia;
		this.paciente = paciente;
		this.medico = medico;
		this.nombrePaciente = nombrePaciente;
		this.nombreMedico = nombreMedico;
	}

	
	public Cita() {
		super();
	}


	public Long getIdCita() {
		return idCita;
	}

	public void setIdCita(Long idCita) {
		this.idCita = idCita;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public LocalDate getDia() {
		return dia;
	}

	public void setDia(LocalDate dia) {
		this.dia = dia;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public String getNombrePaciente() {
		String fullnamePaciente = paciente.getNombres() + " " + paciente.getApellidos();
		return fullnamePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreMedico() {
		String fullnameMedico ;
		fullnameMedico = medico.getNombres() + " " + medico.getApellidos();
		return fullnameMedico;
	}

	public void setNombreMedico(String nombreMedico) {
		this.nombreMedico = nombreMedico;
	}

	
	
}
