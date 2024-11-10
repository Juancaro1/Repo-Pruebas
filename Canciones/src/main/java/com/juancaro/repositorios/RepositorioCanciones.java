package com.juancaro.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juancaro.modelos.Canciones;

@Repository
public interface RepositorioCanciones extends CrudRepository<Canciones, Long>{
	
}
