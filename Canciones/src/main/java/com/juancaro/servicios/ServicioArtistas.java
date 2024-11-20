package com.juancaro.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancaro.modelos.Artista;
import com.juancaro.repositorios.RepositorioArtistas;

@Service
public class ServicioArtistas {

    @Autowired
    private RepositorioArtistas repositorioArtistas;

    public List<Artista> obtenerTodosLosArtistas(){
        return (List<Artista>) repositorioArtistas.findAll();
    }

    public Artista obtenerArtistaPorId(Long id){
        return repositorioArtistas.findById(id).orElse(null);
    }

    public Artista agregarArtista(Artista artista){
        return repositorioArtistas.save(artista);
    }
    
    public void eliminaCancion(Long id){
        this.repositorioArtistas.deleteById(id);
    }
}
