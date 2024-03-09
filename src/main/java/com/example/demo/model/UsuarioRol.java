package com.example.demo.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarioRol")
public class UsuarioRol {

	@EmbeddedId
	private UsuarioRolPK usuarioRolPK;

	@ManyToOne
	@MapsId("idUsuario")
	@JoinColumn(name = "idUsuario", nullable = false)
	private Usuario usuario;

	@ManyToOne
	@MapsId("idRol")
	@JoinColumn(name = "idRol", nullable = false)
	private Rol rol;

	public UsuarioRolPK getUsuarioRolPK() {
		return usuarioRolPK;
	}

	public void setUsuarioRolPK(UsuarioRolPK usuarioRolPK) {
		this.usuarioRolPK = usuarioRolPK;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
