package com.glamour.restapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glamour.restapi.bussines.UsuarioDTO;
import com.glamour.restapi.entity.Usuario;
import com.glamour.restapi.repository.UsuariosRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuariosRepository usuariosRepository;

	@Autowired
	private ModelMapper modelMapper;

	/* usuariosRepository.findById(usuarioId); */

	public List<UsuarioDTO> listarUsuarioPorId(String usuarioId){
		return usuariosRepository.findById(usuarioId)
				.stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	public List<UsuarioDTO> listarUsuarios() {
		return usuariosRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
	}

	private UsuarioDTO convertEntityToDto(Usuario usuario) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
		return usuarioDTO;
	}

	@SuppressWarnings("unused")
	private Usuario convertDtoToEntity(UsuarioDTO usuarioDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Usuario usuario = new Usuario();
		usuario = modelMapper.map(usuarioDTO, Usuario.class);
		return usuario;
	}
}
