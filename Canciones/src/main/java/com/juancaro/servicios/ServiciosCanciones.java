package com.juancaro.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancaro.modelos.Canciones;
import com.juancaro.repositorios.RepositorioCanciones;

@Service
public class ServiciosCanciones {
	
	@Autowired
	private RepositorioCanciones repositorio;
	
	public List<Canciones> obtenerTodasLasCanciones(){
		return (List<Canciones>) repositorio.findAll();
	}
	
	public Canciones obtenerCancionPorId(Long id) {
		return repositorio.findById(id).orElse(null);
	}
}