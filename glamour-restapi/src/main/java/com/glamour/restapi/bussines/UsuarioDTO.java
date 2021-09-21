package com.glamour.restapi.bussines;

import java.io.Serializable;

import com.glamour.restapi.entity.Usuario;

public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String _id;
	private String nombreUsuario;
	private String email;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario usuario) {
		
		_id =  usuario.get_id();
		nombreUsuario = usuario.getNombreUsuario();
		email = usuario.getEmail();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
