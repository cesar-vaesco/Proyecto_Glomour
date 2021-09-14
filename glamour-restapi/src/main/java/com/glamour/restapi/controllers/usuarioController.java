package com.glamour.restapi.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glamour.restapi.entity.Usuario;
import com.glamour.restapi.exception.ResourceNotFoundException;
import com.glamour.restapi.repository.UsuariosRepository;

@RestController
@RequestMapping("${url.usuario}")
public class usuarioController {

	@Autowired
	private UsuariosRepository usuariosRepository;

	/* http://localhost:8080/authentication/v1/usuarios */
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios() {
		return usuariosRepository.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuario> listarUsuariosPorId(@PathVariable(value = "id") String usuarioId)
			throws ResourceNotFoundException {
		Usuario usuario = usuariosRepository.findById(usuarioId).orElseThrow(
				() -> new ResourceNotFoundException("No se ha encontrado el usuario con el id:: " + usuarioId));
		return ResponseEntity.ok(usuario);
	}
}

/*
 * @GetMapping("/employees/{id}") public ResponseEntity < Employee >
 * getEmployeeById(@PathVariable(value = "id") Long employeeId) throws
 * ResourceNotFoundException { Employee employee =
 * employeeRepository.findById(employeeId) .orElseThrow(() - > new
 * ResourceNotFoundException("Employee not found for this id :: " +
 * employeeId)); return ResponseEntity.ok().body(employee); }
 */