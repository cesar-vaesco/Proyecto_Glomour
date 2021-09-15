package com.glamour.restapi.repository;




import org.springframework.data.mongodb.repository.MongoRepository;

import com.glamour.restapi.entity.Usuario;

public interface UsuariosRepository extends MongoRepository<Usuario, String> {



}
