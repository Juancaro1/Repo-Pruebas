package com.juancaro.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juancaro.modelos.Articulo;



@Repository
public interface RepositorioArticulos extends CrudRepository<Articulo, Long>{

    

}
