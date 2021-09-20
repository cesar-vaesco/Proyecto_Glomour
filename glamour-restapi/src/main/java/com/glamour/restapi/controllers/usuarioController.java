package com.glamour.restapi.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	public ResponseEntity<?> listarUsuarios() {
		List<Usuario> listarUsuarios = usuariosRepository.findAll();
		return new ResponseEntity<>(listarUsuarios, listarUsuarios.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	/* http://localhost:8080/authentication/v1/usuarios/usuarioId */
	@GetMapping("/usuarios/{id}")
	public ResponseEntity<?> listarUsuariosPorId(@PathVariable(value = "id") String usuarioId) {

		Optional<Usuario> usuarioDB = usuariosRepository.findById(usuarioId);

		try {

			if (usuarioDB.isPresent()) {
				return new ResponseEntity<>(usuarioDB, HttpStatus.OK);
			} else {
				// return new ResponseEntity<>("El usuario con el id " + usuarioId + " no
				// existe", HttpStatus.NO_CONTENT);
				return ResponseEntity.status(204).body("El usuario con el id " + usuarioId + " no existe");
			}

		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	/* http://localhost:8080/authentication/v1/registro-usuario */
	@PostMapping("/registro-usuario")
	public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario) throws ResourceNotFoundException {

		try {
			Usuario nuevoUsuario = usuariosRepository.save(usuario);
			return new ResponseEntity<>("El usuario " + nuevoUsuario.getNombreUsuario() + " ha sido creado",
					HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/actualizar-registro/{id}")
	public ResponseEntity<?> actualizarRegistro(@PathVariable("id") String id, @RequestBody Usuario usuario) throws ResourceNotFoundException{

		try {
			usuariosRepository.save(usuario);
			return new ResponseEntity<>("El registro del usuario '"+ usuario.getNombreUsuario()+"' a sido actualizado", HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
	}

}
