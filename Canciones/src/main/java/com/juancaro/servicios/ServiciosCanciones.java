package com.juancaro.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancaro.modelos.Canciones;
import com.juancaro.repositorios.RepositorioCanciones;

@Service
public class ServiciosCanciones {
    @Autowired
    private RepositorioCanciones repositorioCanciones;

    public List<Canciones> obtenerTodasLasCanciones(){
        return (List<Canciones>) repositorioCanciones.findAll();
    }

    public Canciones obtenerCancionPorId(Long id){
        return repositorioCanciones.findById(id).orElse(null);
    }

    public Canciones agregarCancion(Canciones cancion){
        return repositorioCanciones.save(cancion);
    }

    public Canciones actualizaCancion(Canciones cancion){
        return repositorioCanciones.save(cancion);
    }

    public void eliminaCancion(Long id){
        this.repositorioCanciones.deleteById(id);
    }
}
