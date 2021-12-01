package com.glamour.restapi.service;

import java.util.List;

import com.glamour.restapi.entity.Usuario;

public interface IUsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario) throws Exception;

	public void delete(String id);

	public Usuario findById(String id);

}
