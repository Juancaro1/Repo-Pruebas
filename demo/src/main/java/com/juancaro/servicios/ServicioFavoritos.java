package com.juancaro.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancaro.modelos.Articulo;
import com.juancaro.modelos.Usuario;
import com.juancaro.repositorios.RepositorioArticulos;
import com.juancaro.repositorios.RepositorioUsuarios;

import jakarta.transaction.Transactional;

@Service
public class ServicioFavoritos {

	@Autowired
	private RepositorioUsuarios repositorioUsuarios;
	
	@Autowired
	private RepositorioArticulos repositorioArticulos;
	
	@Transactional
	public void agregarfavorito(Long idUsuario, Long idArticulo) {
		Usuario usuario = this.repositorioUsuarios.findById(idUsuario).orElse(null);
		Articulo articulo = this.repositorioArticulos.findById(idArticulo).orElse(null);
		
		usuario.getArticulosFavoritos().add(articulo);
		this.repositorioUsuarios.save(usuario);
	}
	
	@Transactional
	public void quitarFavorito(Long idUsuario, Long idArticulo) {
		Usuario usuario = this.repositorioUsuarios.findById(idUsuario).orElse(null);
		Articulo articulo = this.repositorioArticulos.findById(idArticulo).orElse(null);
		
		usuario.getArticulosFavoritos().remove(articulo);
		this.repositorioUsuarios.save(usuario);
	}

	public List<Articulo> obtenerFavoritosDeUsuario(Long idUsuario) {
        Usuario usuario = repositorioUsuarios.findById(idUsuario).orElse(null);
        return usuario.getArticulosFavoritos();
    }
}
