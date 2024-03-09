package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clinica")
public class Clinica {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Long idClinica;

		@Column(name = "nombre", nullable = false)
		public String nombre;
		
		@Column(name = "telefono", nullable = false)
		public String telefono;
		
		@Column(name = "direccion", nullable = false)
		public String direccion;
		
		@ManyToOne
		@JoinColumn(name="idCiudad", nullable=false)
		public Ciudad ciudad;

		public Long getIdClinica() {
			return idClinica;
		}

		public void setIdClinica(Long idClinica) {
			this.idClinica = idClinica;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public Ciudad getCiudad() {
			return ciudad;
		}

		public void setCiudad(Ciudad ciudad) {
			this.ciudad = ciudad;
		}
		
}
