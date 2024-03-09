package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class RolOpcionPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int idRol;
	private int idOpcion;
	
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public int getIdOpcion() {
		return idOpcion;
	}
	public void setIdOpcion(int idOpcion) {
		this.idOpcion = idOpcion;
	}

}
