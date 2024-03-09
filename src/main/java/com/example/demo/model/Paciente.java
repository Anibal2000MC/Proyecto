package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long idPaciente;

	@Column(name = "nombres", nullable = false)
	public String nombres;

	@Column(name = "apellidos" , nullable = false)
	public String apellidos;

	@Column(name = "nDocumento" , nullable = false)
	public int nDocumento;

	@Column(name = "edad" , nullable = false)
	public int edad;

	@Column(name = "fechaRegistro")
	public Date fechaRegistro;

	@OneToOne
	@JoinColumn(name = "idUsuario" , nullable = false)
	public Usuario usuario;

	public Paciente(Long idPaciente, String nombres, String apellidos, int nDocumento, int edad,
			Date fechaRegistro, Usuario usuario) {
		super();
		this.idPaciente = idPaciente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.nDocumento = nDocumento;
		this.edad = edad;
		this.fechaRegistro = fechaRegistro;
		this.usuario = usuario;
	}
	public Paciente() {
		super();
	}
	@PrePersist
	protected void onCreate() {
		fechaRegistro = new Date();
	}

	public Long getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Long idPaciente) {
		this.idPaciente = idPaciente;
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

	public int getnDocumento() {
		return nDocumento;
	}

	public void setnDocumento(int nDocumento) {
		this.nDocumento = nDocumento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}