package com.juancaro.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.juancaro.modelos.ModeloAutor;
import com.juancaro.modelos.Poema;
import com.juancaro.modelos.Usuario;
import com.juancaro.repositorios.RepositorioAutores;
import com.juancaro.repositorios.RepositorioPoemas;
import com.juancaro.repositorios.RepositorioUsuarios;


@Service
public class ServicioPoemas {

    @Autowired
    private RepositorioPoemas repositorioPoemas;

    @Autowired
    private RepositorioAutores repositorioAutores;


    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    public Poema crear(Poema poema, Long idUsuario){
        Usuario usuario = this.repositorioUsuarios.findById(idUsuario).orElse(null);

        poema.setCreador(usuario);
        return this.repositorioPoemas.save(poema);
    }

    public List<Poema> obtenerTodos(){
        return (List<Poema>) this.repositorioPoemas.findAll(Sort.by(Sort.Order.asc("titulo")));
    }

    public Poema obtenerPorId(Long id){
        return this.repositorioPoemas.findById(id).orElse(null);
    }

    public Poema actualizar(Poema poema){
        return this.repositorioPoemas.save(poema);
    }

    public void eliminar(Long id){
        repositorioPoemas.deleteById(id);
    }

    public ModeloAutor findByNombre(String nombre) {
        return repositorioAutores.findByNombre(nombre);
    }

    public List<Poema> obtenerPoemasPorAutor(Long idAutor) {
        return repositorioPoemas.findByAutor_Id(idAutor);
    }

}



