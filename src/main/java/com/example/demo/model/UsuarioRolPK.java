package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class UsuarioRolPK implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idUsuario;
	private int idRol;
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
