package com.glamour.restapi.entity;




import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

	/* Identificador único */
	@Id
	private String _id;

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombreUsuario;
	
	
	private String email;
	private String contrasenia;

	public Usuario() {
	}


	public Usuario(String _id, String nombre, String apellidoPaterno, String apellidoMaterno, String nombreUsuario,
			String email, String contrasenia) {
		super();
		this._id = _id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombreUsuario = nombreUsuario;
		this.email = email;
		this.contrasenia = contrasenia;
	}


	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
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

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	@Override
	public String toString() {
		return "Usuario [_id=" + _id + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario + ", email=" + email
				+ "]";
	}

	
	
}
