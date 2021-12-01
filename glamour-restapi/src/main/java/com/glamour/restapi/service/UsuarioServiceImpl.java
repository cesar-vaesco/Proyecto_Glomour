package com.glamour.restapi.service;

import java.util.List;
import java.util.regex.Pattern;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glamour.restapi.entity.Usuario;
import com.glamour.restapi.exception.UserValidException;
import com.glamour.restapi.repository.UsuariosRepository;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuariosRepository repository;

	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>) repository.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) throws UserValidException {

		Usuario _usuario = new Usuario();

		if (isUserValid(usuario)) {
			_usuario.setNombre(usuario.getNombre());
			_usuario.setApellidoPaterno(usuario.getApellidoPaterno());
			_usuario.setApellidoMaterno(usuario.getApellidoMaterno());
			_usuario.setNombreUsuario(usuario.getNombreUsuario());
			_usuario.setEmail(usuario.getEmail());
			_usuario.setContrasenia(usuario.getContrasenia());
		}
		return _usuario;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isUserValid(Usuario usuario) throws UserValidException {

		if (!isStringValid(usuario.getNombre())) {
			throw new UserValidException("Nombre no es valido");
		}

		if (!isStringValid(usuario.getApellidoPaterno())) {
			throw new UserValidException("Apellido paterno no es valido");
		}

		if (!isStringValid(usuario.getNombreUsuario())) {
			throw new UserValidException("Usuario no es valido");
		}

		if (!isStringValid(usuario.getContrasenia())) {
			throw new UserValidException("Contrasenia no es valido");
		}

		if (!isEmailValid(usuario.getEmail())) {
			throw new UserValidException("Email no es valido");
		}

		if (!isStringWithoutNumberValid(usuario.getNombre())) {
			throw new UserValidException("Nombre no es valido");
		}

		if (!isStringWithoutNumberValid(usuario.getApellidoPaterno())) {
			throw new UserValidException("Paterno no es valido");
		}

		if (!isStringWithoutNumberValid(usuario.getApellidoMaterno())) {
			throw new UserValidException("Materno no es valido");
		}

		return true;
	}

	private boolean isStringValid(String cadena) {
		cadena = cadena.trim();
		if (cadena != null) {
			if (cadena.length() >= 3) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	
	private boolean isEmailValid(String correo) {
		correo = correo.trim();
		return Pattern.compile(
				"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
				.matcher(correo).find();
	}

	
	private boolean isStringWithoutNumberValid(String cadena) {
		cadena = cadena.trim();
		return Pattern.compile("^[a-záéíóúA-Z ]{3,}$").matcher(cadena).find();
	}
}
