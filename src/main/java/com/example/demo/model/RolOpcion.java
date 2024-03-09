package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="rolOpcion")
public class RolOpcion {
	
	@EmbeddedId
	private RolOpcionPK rolOpcionPK;
	
	@ManyToOne
	@MapsId("idRol")
	@JoinColumn(name = "idRol", nullable = false)
	private Rol rol;
	
	@ManyToOne
	@MapsId("idOpcion")
	@JoinColumn(name = "idOpcion", nullable = false)
	private Opcion opcion;

	public RolOpcionPK getRolOpcionPK() {
		return rolOpcionPK;
	}

	public void setRolOpcionPK(RolOpcionPK rolOpcionPK) {
		this.rolOpcionPK = rolOpcionPK;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}
	
	
}
