package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="medico")
public class Medico {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long idMedico;
	
	@Column(name="nombres", nullable=false)
	public String nombres;
	
	@Column(name="apellidos", nullable=false)
	public String apellidos;
	
	@ManyToOne
	@JoinColumn(name = "idEspecialidad", nullable = false)
	public Especialidad especialidad;
	
	@ManyToOne
	@JoinColumn(name = "idClinica", nullable = false)
	public Clinica clinica;
	
	@OneToOne
	@JoinColumn(name = "idUsuario")
	public Usuario usuario;
	
	@Transient
	public String nombreCompleto;

	public String getNombreCompleto() {
		nombreCompleto = getNombres()+ " " + getApellidos();
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public Medico(Long idMedico, String nombres, String apellidos, Especialidad especialidad, Clinica clinica,
			Usuario usuario) {
		super();
		this.idMedico = idMedico;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
		this.clinica = clinica;
		this.usuario = usuario;
	}

	public Medico() {
		super();
	}

	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
