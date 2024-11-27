package com.juancaro.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juancaro.modelos.ModeloAutor;

@Repository
public interface RepositorioAutores extends CrudRepository<ModeloAutor, Long>{

    ModeloAutor findByNombre(String nombre);
}
