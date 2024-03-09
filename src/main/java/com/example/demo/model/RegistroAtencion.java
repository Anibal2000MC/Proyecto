package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name="registroAtencion")
public class RegistroAtencion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRegistro;
	
	@Column(name="nombres")
	public String nombres;
	
	@Column(name="apellidos")
	public String apellidos;
	
	@Column(name="clinica")
	public String clinica;
	
	@Column(name="email")
	public String email;
	
	@Column(name="celular")
	public int celular;
	
	@Column(name="motivo")
	public String motivo;
	
	@Column(name="consulta")
	public String consulta;
	
	@Transient
	public String nombreEmisor;
	
	public String getNombreEmisor() {
		nombreEmisor = getNombres() + " " + getApellidos();
		return nombreEmisor;
	}

	public void setNombreEmisor(String nombreEmisor) {
		this.nombreEmisor = nombreEmisor;
	}

	
	public RegistroAtencion(Long idRegistro, String nombres, String apellidos, String clinica, String email, int celular,
			String motivo, String consulta) {
		super();
		this.idRegistro = idRegistro;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.clinica = clinica;
		this.email = email;
		this.celular = celular;
		this.motivo = motivo;
		this.consulta = consulta;
	}
	
	public RegistroAtencion() {
		super();
	}

	public Long getIdRegistro() {
		return idRegistro;
	}

	public void setIdRegistro(Long idRegistro) {
		this.idRegistro = idRegistro;
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

	public String getClinica() {
		return clinica;
	}

	public void setClinica(String clinica) {
		this.clinica = clinica;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getConsulta() {
		return consulta;
	}

	public void setConsulta(String consulta) {
		this.consulta = consulta;
	}
	
	
}
