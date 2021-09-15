package com.glamour.restapi.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glamour.restapi.entity.Usuario;
import com.glamour.restapi.exception.ResourceNotFoundException;
import com.glamour.restapi.repository.UsuariosRepository;

@RestController
@RequestMapping("${url.usuario}")
public class usuarioController {

	private static final Logger log = LoggerFactory.getLogger(usuarioController.class);

	@Autowired
	private UsuariosRepository usuariosRepository;

	/* http://localhost:8080/authentication/v1/usuarios */
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuariosRepository.findAll();
	}

	/* http://localhost:8080/authentication/v1/usuarios/usuarioId */
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> listarUsuariosPorId(@PathVariable(value = "id") String usuarioId)
			throws ResourceNotFoundException {
		ObjectId objId = new ObjectId(usuarioId);
		Usuario usuario = usuariosRepository.findById(usuarioId).orElseThrow(
				() -> new ResourceNotFoundException("No se ha encontrado el usuario con el id:: " + objId));
		return ResponseEntity.ok(usuario);
	}

	@PostMapping("/registro-usuario")
	public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) throws ResourceNotFoundException {

		try {
			Usuario nuevoUsuario = usuariosRepository.save(usuario);

			return new ResponseEntity<Usuario>(nuevoUsuario, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
