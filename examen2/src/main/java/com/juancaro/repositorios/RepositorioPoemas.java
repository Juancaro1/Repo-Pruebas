package com.juancaro.repositorios;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.juancaro.modelos.Poema;

@Repository
public interface RepositorioPoemas extends CrudRepository<Poema, Long>{

    List<Poema> findAll(Sort sort);
    List<Poema> findByAutor_Id(Long idAutor);
}
