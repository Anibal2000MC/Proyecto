package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="opcion")
public class Opcion {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "idOpcion")
	private Long  idOpcion;
	
	@Column(name = "nombre")
	private String  nombre;
	
	@Column(name = "ruta")
	private String  ruta;
	
	@Column(name = "estado")
	private String  estado;
	
	@Column(name = "tipo")
	private int tipo;

	public Long getIdOpcion() {
		return idOpcion;
	}

	public void setIdOpcion(Long idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
