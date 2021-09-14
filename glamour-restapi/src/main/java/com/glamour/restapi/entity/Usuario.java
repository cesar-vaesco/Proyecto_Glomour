package com.glamour.restapi.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "usuarios")
public class Usuario {

	/* Identificador único */
	@Id
    private long id;

	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombreUsuario;
	private String correoEletronico;
	private String contrasenia;

	public Usuario() {
	}

	public Usuario(long _id, String nombre, String apellidoPaterno, String apellidoMaterno, String nombreUsuario,
			String correoEletronico, String contrasenia) {
		super();
		this.id = _id;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombreUsuario = nombreUsuario;
		this.correoEletronico = correoEletronico;
		this.contrasenia = contrasenia;
	}

	public long get_id() {
		return id;
	}

	public void set_id(long _id) {
		this.id = _id;
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

	public String getCorreoEletronico() {
		return correoEletronico;
	}

	public void setCorreoEletronico(String correoEletronico) {
		this.correoEletronico = correoEletronico;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
